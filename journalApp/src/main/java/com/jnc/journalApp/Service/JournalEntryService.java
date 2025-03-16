package com.jnc.journalApp.Service;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import  com.jnc.journalApp.repository.JournalEntryRepo;
import  com.jnc.journalApp.Entity.journalEntry;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class JournalEntryService{

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(journalEntry JournalEntry){
        try{
            JournalEntry.setDate(LocalDateTime.now());
            journalEntryRepo.save(JournalEntry);
        } catch (Exception e) {
            log.error("Exception: ",e);
        }
    }

    public List<journalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<journalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepo.deleteById(id);
    }
}
