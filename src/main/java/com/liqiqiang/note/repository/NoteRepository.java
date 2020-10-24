package com.liqiqiang.note.repository;

import com.liqiqiang.note.entity.Note;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {

}
