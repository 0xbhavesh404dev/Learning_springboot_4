package com.chapter4_linking_two_databases.chapter4_linking_two_databases.repository;

import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.JournalEntry;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
