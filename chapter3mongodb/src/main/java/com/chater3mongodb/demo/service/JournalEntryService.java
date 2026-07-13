package com.chater3mongodb.demo.service;

import com.chater3mongodb.demo.entity.JournalEntry;
import com.chater3mongodb.demo.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getJournalEntryById(ObjectId id) {
        return journalEntryRepository.findById(String.valueOf(id));
    }

    public boolean deleteById(ObjectId id) {
        if (journalEntryRepository.existsById(id.toString())) {
            journalEntryRepository.deleteById(id.toString());
            return true;
        }
        return false;
    }
}
