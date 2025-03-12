package com.jnc.journalApp.Controller;

import org.springframework.web.bind.annotation.*;
import com.jnc.journalApp.Entity.journalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long,journalEntry> journalEntries = new HashMap();

    @GetMapping
    public List<journalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public journalEntry getJournalEntryById(@PathVariable long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public journalEntry deleteJournalEntryById(@PathVariable long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{id}")
    public journalEntry updateJournalEntryById(@PathVariable long id,@RequestBody journalEntry je){
        return journalEntries.put(id,je);
    }

}
