package com.ichwan.message.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "logs")
public class LogEntry {

    @Id
    private String id;
    private String level;
    private String message;
    private Instant timestamp;
    private Map<String, String> metadata;
}
