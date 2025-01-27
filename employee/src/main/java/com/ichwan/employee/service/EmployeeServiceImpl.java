package com.ichwan.employee.service;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.dto.EmployeesDto;
import com.ichwan.employee.entity.Accounts;
import com.ichwan.employee.entity.Employees;
import com.ichwan.employee.exception.EmployeeAlreadyExistsException;
import com.ichwan.employee.exception.ResourceNotFoundException;
import com.ichwan.employee.mapper.EmployeesMapper;
import com.ichwan.employee.repository.AccountsRepository;
import com.ichwan.employee.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeesService{

    private AccountsRepository accountsRepository;
    private EmployeesRepository employeesRepository;

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
        Employees employees = new Employees();
        Optional<Employees> name = employeesRepository.findByName(employees.getName());
        if (name.isPresent()){
            throw new EmployeeAlreadyExistsException("Employees already registered: "+employeesDto.getName());
        }

        employeesRepository.save(employees);
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
