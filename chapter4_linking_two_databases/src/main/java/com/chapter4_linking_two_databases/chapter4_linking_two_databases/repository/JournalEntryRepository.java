package com.chapter4_linking_two_databases.chapter4_linking_two_databases.repository;

import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
