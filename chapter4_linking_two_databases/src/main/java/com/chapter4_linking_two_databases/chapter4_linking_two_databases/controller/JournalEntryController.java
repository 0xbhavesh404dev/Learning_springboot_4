package com.chapter4_linking_two_databases.chapter4_linking_two_databases.controller;

import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.JournalEntry;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.entity.User;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.service.JournalEntryService;
import com.chapter4_linking_two_databases.chapter4_linking_two_databases.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {

        User user = userService.findByusername(userName);

        if (user != null) {
            List<JournalEntry> all = user.getJournalEntries();

            if (all != null && !all.isEmpty()) {
                return new ResponseEntity<>(all, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(
            @RequestBody JournalEntry myEntry,
            @PathVariable String userName) {

        try {
            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{findId}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId findId) {

        return journalEntryService.findById(findId)
                .map(entry -> new ResponseEntity<>(entry, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("id/{userName}/{id}")
    public ResponseEntity<?> deleteEntry(
            @PathVariable ObjectId id,
            @PathVariable String userName) {

        journalEntryService.deleteById(id, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<JournalEntry> updateJournalById(
            @PathVariable ObjectId id,
            @RequestBody JournalEntry newEntry) {

        JournalEntry old = journalEntryService.findById(id).orElse(null);

        if (old != null) {

            old.setTitle(
                    newEntry.getTitle() != null && !newEntry.getTitle().isEmpty()
                            ? newEntry.getTitle()
                            : old.getTitle());

            old.setContent(
                    newEntry.getContent() != null && !newEntry.getContent().isEmpty()
                            ? newEntry.getContent()
                            : old.getContent());

            journalEntryService.saveEntry(old);

            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}