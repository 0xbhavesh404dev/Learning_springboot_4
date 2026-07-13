package com.chapter4_linking_two_databases.chapter4_linking_two_databases.service;

import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.JournalEntry;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.User;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.repository.JournalEntryRepository;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;


@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(String.valueOf(id));
    }

    public boolean deleteById(ObjectId id) {
        if (userRepository.existsById(id.toString())) {
            userRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }

    public User findByusername(String userName) {
        return userRepository.findById(userName).orElse(null);
    }


}
