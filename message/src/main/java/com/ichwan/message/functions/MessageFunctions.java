package com.ichwan.message.functions;

import com.ichwan.message.dto.EmployeeMessageDto;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<EmployeeMessageDto, EmployeeMessageDto> email(){
        return employeeMessageDto -> {
            logger.info("Processing email for employee: {}", employeeMessageDto);
            // Here you would implement the logic to send an email
            // For now, we just log the action
            return employeeMessageDto;
        };
    }

    @Bean
    public Function<EmployeeMessageDto, Long> sms(){
        return employeeMessageDto -> {
            logger.info("Processing SMS for employee: {}", employeeMessageDto.name());
            // Here you would implement the logic to send an sms
            // For now, we just log the action
            return employeeMessageDto.id();
        };
    }
}