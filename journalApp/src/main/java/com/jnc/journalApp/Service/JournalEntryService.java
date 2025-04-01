package com.jnc.journalApp.Service;

import com.jnc.journalApp.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import  com.jnc.journalApp.repository.JournalEntryRepo;
import  com.jnc.journalApp.Entity.journalEntry;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class JournalEntryService{

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserService userService;



    @Transactional
    public void saveEntry(journalEntry JournalEntry, String userName){
        try{
            User user = userService.findByUserName(userName);
            JournalEntry.setDate(LocalDateTime.now());
            journalEntry saved = journalEntryRepo.save(JournalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException("An Error Has Occurred:" +e);
        }
    }

    public void saveEntry(journalEntry JournalEntry){
        journalEntryRepo.save(JournalEntry);
    }

    public List<journalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<journalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }


    @Transactional
    public boolean deleteById(ObjectId id, String username){
        boolean isRemoved = false;
        try{
            User user = userService.findByUserName(username);
            isRemoved = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(isRemoved){
                userService.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while Deleting Journal.",e);
        }
        return isRemoved;
    }

}
