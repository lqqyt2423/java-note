package com.liqiqiang.note.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note {

    @Id private String id;
    private String content;

    public Note() {}

    public Note(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Note[id=%s, content=%s]", id, content.length() > 80 ? content.substring(0, 80) : content);
    }
}
