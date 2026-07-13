package com.chater3mongodb.demo.controller;


import com.chater3mongodb.demo.entity.JournalEntry;
import com.chater3mongodb.demo.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")

public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myentry){
        myentry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myentry);
        return myentry;
    }

    @GetMapping("id/{find_id}")
    public JournalEntry getEntryById(@PathVariable("find_id") ObjectId findId){
        return journalEntryService.getJournalEntryById(findId).orElse(null);

    }

    @DeleteMapping
    public void deleteEntry(@RequestBody ObjectId myentry){
        journalEntryService.deleteById(myentry);

    }




    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable ObjectId id,
                                          @RequestBody JournalEntry newEntry) {

        JournalEntry old = journalEntryService.getJournalEntryById(id).orElse(null);

        if (old != null) {
            old.setTitle(newEntry.getTitle() != null &&
                    !newEntry.getTitle().equals("")
                    ? newEntry.getTitle()
                    : old.getTitle());

            old.setContent(newEntry.getContent() != null &&
                    !newEntry.getContent().equals("")
                    ? newEntry.getContent()
                    : old.getContent());
        }

        journalEntryService.saveEntry(old);
        return old;
    }





}
