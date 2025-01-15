package com.ichwan.employee.service;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.dto.EmployeesDto;
import com.ichwan.employee.entity.Employees;
import com.ichwan.employee.repository.AccountsRepository;
import com.ichwan.employee.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeesService{

    private AccountsRepository accountsRepository;
    private EmployeesRepository employeesRepository;

    @Override
    public EmployeesDto getEmployee(String name) {

        return null;
    }

    @Override
    public void createAccount(AccountsDto accountsDto) {

    }

    @Override
    public void registerEmployee(EmployeesDto employeesDto) {

    }

    @Override
    public boolean updateAccount(String email) {
        return false;
    }

    @Override
    public boolean deleteEmployees(String name) {
        return false;
    }

    @Override
    public boolean deleteAccount(String email) {
        return false;
    }
}
