package com.ichwan.employee.service;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.dto.EmployeesDto;

public interface EmployeesService {

    EmployeesDto getEmployee(String name);

    void createAccount(AccountsDto accountsDto);

    void registerEmployee(EmployeesDto employeesDto);

    boolean updateAccount(String email);

    boolean deleteEmployees(String name);

    boolean deleteAccount(String email);
}
