package com.jnc.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.jnc.journalApp.Entity.journalEntry;

public interface JournalEntryRepo extends MongoRepository<journalEntry, ObjectId>{

}
