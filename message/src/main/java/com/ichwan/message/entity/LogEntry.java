package com.ichwan.message.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "logs")
public class LogEntry {

    private String id;
    private String level;
    private String message;
    private Instant timestamp;
    private Map<String, String> metadata;
}
