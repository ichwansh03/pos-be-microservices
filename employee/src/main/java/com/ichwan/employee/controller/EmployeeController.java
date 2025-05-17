package com.ichwan.employee.controller;

import com.ichwan.employee.dto.AccountsDto;
import com.ichwan.employee.dto.EmployeeInfoDto;
import com.ichwan.employee.dto.EmployeesDto;
import com.ichwan.employee.dto.ResponseDto;
import com.ichwan.employee.service.EmployeesService;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final EmployeesService employeesService;
    private final EmployeeInfoDto employeeInfoDto;

    public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

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

    @GetMapping("/employee-info")
    public ResponseEntity<EmployeeInfoDto> getEmployeeInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeInfoDto);
    }

    @Retry(name = "getVersionInfo", fallbackMethod = "getVersionInfoFallback")
    @GetMapping("/version-info")
    public ResponseEntity<String> getVersionInfo() {
        return ResponseEntity.status(HttpStatus.OK).body("Version 1.1");
    }

    public ResponseEntity<String> getVersionInfoFallback(Throwable throwable) {
        logger.debug("getVersionInfoFallback called with exception: {}", throwable.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Version 1.0.0");
    }
}
