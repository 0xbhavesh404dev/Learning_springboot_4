package com.chapter4_linking_two_databases.chapter4_linking_two_databases.controller;


import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.JournalEntry;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.User;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.service.JournalEntryService;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public User createEntry(@RequestBody User myentry){
        userService.saveEntry(myentry);
        return myentry;
    }

    @GetMapping("id/{find_id}")
    public User getEntryById(@PathVariable("find_id") ObjectId findId){
        return userService.findById(findId).orElse(null);

    }

    @DeleteMapping
    public void deleteEntry(@RequestBody ObjectId myentry){
        userService.deleteById(myentry);

    }




    @PutMapping("/{username}")
    public User updatePassword(@PathVariable String username,
                             @RequestBody User newEntry) {

        User old = userService.findByusername(username);

        if (old != null) {
            old.setUsername(newEntry.getUsername() != null &&
                    !newEntry.getUsername().equals("")
                    ? newEntry.getUsername()
                    : old.getUsername());

            old.setPassword(newEntry.getPassword() != null &&
                    !newEntry.getPassword().equals("")
                    ? newEntry.getPassword()
                    : old.getPassword());
        }

        userService.saveEntry(old);
        return old;
    }





}
