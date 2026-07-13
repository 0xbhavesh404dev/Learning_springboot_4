package com.chater3mongodb.demo.repository;

import com.chater3mongodb.demo.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

}
