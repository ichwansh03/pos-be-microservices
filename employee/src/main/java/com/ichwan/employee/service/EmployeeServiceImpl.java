package com.ichwan.employee.service;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.dto.EmployeeMessageDto;
import com.ichwan.employee.dto.EmployeesDto;
import com.ichwan.employee.entity.Accounts;
import com.ichwan.employee.entity.Employees;
import com.ichwan.employee.exception.EmployeeAlreadyExistsException;
import com.ichwan.employee.exception.ResourceNotFoundException;
import com.ichwan.employee.mapper.EmployeesMapper;
import com.ichwan.employee.repository.AccountsRepository;
import com.ichwan.employee.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeesService{

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final StreamBridge streamBridge;
    private AccountsRepository accountsRepository;
    private EmployeesRepository employeesRepository;

    @Retryable(retryFor = {ResourceNotFoundException.class}, maxAttempts = 5)
    @Override
    public EmployeesDto getEmployee(String name) {

        Employees employees = employeesRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found")
        );

        return EmployeesMapper.mapToEmployeesDto(employees, new EmployeesDto());
    }

    @Override
    public void createAccount(AccountsDto accountsDto) {
        Accounts accounts = new Accounts();
        accounts.setEmpId(accounts.getEmpId());
        long randomId = 10000L + new Random().nextInt(9000);

        accounts.setAccountNumber(randomId);
        accounts.setType("Employee");
        accounts.setEmail(accounts.getEmpId()+"@mail.com");
        accountsRepository.save(accounts);
    }

    @Override
    public void registerEmployee(EmployeesDto employeesDto) {
        Optional<Employees> existingEmployee = employeesRepository.findByName(employeesDto.getName());
        if (existingEmployee.isPresent()) {
            throw new EmployeeAlreadyExistsException("Employees already registered: " + employeesDto.getName());
        }

        Employees employees = EmployeesMapper.mapToEmployees(employeesDto, new Employees());
        employeesRepository.save(employees);
        sendCommunication(employees);
    }

    private void sendCommunication(Employees employees) {
        var emplooyeeMsgDto = new EmployeeMessageDto(employees.getEmpId(), employees.getName(), employees.getPhone(), employees.getAddress(), employees.getInBranch(), employees.getAge());
        logger.info("Sending communication for employee: {}", emplooyeeMsgDto);
        var result = streamBridge.send("employee-out-0", emplooyeeMsgDto);
        logger.info("Communication sent successfully: {}", result);
    }

    @Override
    public boolean deleteEmployees(String name) {
        Employees employees = employeesRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found")
        );
        employeesRepository.deleteById(employees.getEmpId());
        return true;
    }
}
