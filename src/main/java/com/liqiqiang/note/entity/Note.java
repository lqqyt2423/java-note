package com.liqiqiang.note.entity;

import org.springframework.data.annotation.Id;

public class Note {

    @Id private String id;
    private String content;

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
        return String.format("Note[id=%s, content=%s...]", id, content.substring(0, 80));
    }
}
