package com.ichwan.message.service;

import com.ichwan.message.entity.LogEntry;
import com.ichwan.message.repository.LogEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LogEntryService {

    private final LogEntryRepository repository;

    @KafkaListener(topics = "log-entries", groupId = "log-entry-group" )
    public void consume(String message) {
        LogEntry logEntry = new LogEntry();
        logEntry.setMessage(message);
        logEntry.setLevel("INFO");
        logEntry.setTimestamp(java.time.Instant.now());
        logEntry.setMetadata(new HashMap<>());
        logEntry.setId(UUID.randomUUID().toString());
        repository.save(logEntry);
    }

}
