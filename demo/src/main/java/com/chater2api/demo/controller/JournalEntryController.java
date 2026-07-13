package com.chater2api.demo.controller;

import com.chater2api.demo.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("journal")
public class JournalEntryController {
    private HashMap<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping  //get
    public List<JournalEntry> getAll(){
        return  new ArrayList<>(journalEntries.values());
    }

    @PostMapping  //post
    public boolean CreateEntry(@RequestBody JournalEntry data){
        journalEntries.put(data.getId(), data);
        return true;
    }

    @GetMapping("id/{get_id}")  //request parameters
    public JournalEntry getEntry(@PathVariable Long get_id){
        return journalEntries.get(get_id);
    }

    @DeleteMapping("id/{get_id}")  //request parameters
    public JournalEntry deleteEntry(@PathVariable Long get_id){
        return journalEntries.remove(get_id);
    }

    @PutMapping("id/{update_id}")
    public JournalEntry updateEntry(@PathVariable Long update_id, @RequestBody JournalEntry data){
        return journalEntries.put(update_id, data);
    }
}
