package com.ichwan.message.kafkaexample.config;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "pos", groupId = "groupId")
    void listener(String data) {
        logger.info("listener received "+data+" in here");
    }
}
