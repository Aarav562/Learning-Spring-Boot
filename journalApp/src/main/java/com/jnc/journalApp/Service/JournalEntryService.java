package com.jnc.journalApp.Service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import  com.jnc.journalApp.repository.JournalEntryRepo;
import  com.jnc.journalApp.Entity.journalEntry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService{

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(journalEntry JournalEntry){
        journalEntryRepo.save(JournalEntry);
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
