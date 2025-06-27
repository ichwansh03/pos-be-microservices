package com.ichwan.employee.functions;

import com.ichwan.employee.service.EmployeesService;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EmployeeFunctions {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeFunctions.class);

    @Bean
    public Consumer<Long> updateCommunication(EmployeesService employeesService) {
        return empId -> {
            logger.info("Updating communication for employee with ID: {}", empId);
            employeesService.updateCommunicationStatus(empId);
        };
    }
}
