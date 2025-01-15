package com.ichwan.employee.mapper;

import com.ichwan.employee.dto.EmployeesDto;
import com.ichwan.employee.entity.Employees;

public class EmployeesMapper {

    public static EmployeesDto mapToEmployeesDto(Employees employees, EmployeesDto employeesDto) {
        employeesDto.setName(employees.getName());
        employeesDto.setAge(employees.getAge());
        employeesDto.setAddress(employees.getAddress());
        employeesDto.setPhone(employees.getPhone());
        employeesDto.setInBranch(employees.getInBranch());
        return employeesDto;
    }

    public static Employees mapToEmployees(EmployeesDto employeesDto, Employees employees) {
        employees.setName(employeesDto.getName());
        employees.setAge(employeesDto.getAge());
        employees.setPhone(employeesDto.getPhone());
        employees.setAddress(employeesDto.getAddress());
        employees.setInBranch(employeesDto.getInBranch());
        return employees;
    }
}
