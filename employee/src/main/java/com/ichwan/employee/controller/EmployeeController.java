package com.ichwan.employee.controller;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.dto.EmployeesDto;
import com.ichwan.employee.dto.ResponseDto;
import com.ichwan.employee.service.EmployeesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class EmployeeController {

    private EmployeesService employeesService;

    @PostMapping("/create/employee")
    public ResponseEntity<ResponseDto> createEmployee(@Valid @RequestBody EmployeesDto employeesDto) {
        employeesService.registerEmployee(employeesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED, "Employee successfully registered"));
    }

    @PostMapping("/create/account")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody AccountsDto accountsDto) {
        employeesService.createAccount(accountsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED, "Employee successfully registered"));
    }

    @GetMapping("/employee")
    public ResponseEntity<EmployeesDto> getEmployeeDetail(@RequestParam String name) {
        EmployeesDto employeesDto = employeesService.getEmployee(name);
        return ResponseEntity.status(HttpStatus.OK).body(employeesDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteEmployee(@RequestParam String name) {
        boolean isDeleted = employeesService.deleteEmployees(name);
        if (isDeleted) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseDto(HttpStatus.NO_CONTENT, "employee successfully deleted"));
        else return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(HttpStatus.EXPECTATION_FAILED, "failed to delete employee"));
    }
}
