package com.ichwan.employee.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "employee")
@Data
public class EmployeeInfoDto {

    private String message;
    private Map<String, String> contactDetails;
}
