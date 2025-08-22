package com.ichwan.message.repository;

import com.ichwan.message.entity.LogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends MongoRepository<String, LogEntry> {
}
