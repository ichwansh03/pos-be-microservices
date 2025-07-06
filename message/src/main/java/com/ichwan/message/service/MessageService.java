package com.ichwan.message.service;

import com.ichwan.message.dto.EmployeeMessageDto;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(MessageService.class);

    @RabbitListener(queues = "spring")
    public EmployeeMessageDto receiveMessage(EmployeeMessageDto employee) {
        // Process the received message
        logger.info("Received message for employee: {}", employee);
        return employee;
    }
}
