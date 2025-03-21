package com.jnc.journalApp.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


@Document(collection = "journalEntry")
@Data
public class journalEntry {
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;
}
