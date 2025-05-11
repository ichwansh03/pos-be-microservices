package com.ichwan.employee.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "employee")
@Component
@Getter
@Setter
public class EmployeeInfoDto {

    private String message;
    private Map<String, String> contactDetails;
}
