package com.liqiqiang.note.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.liqiqiang.note.entity.Note;
import com.liqiqiang.note.repository.NoteRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    private Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> index() {
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> show(@PathVariable("id") String id) {
        return noteRepository.findById(id);
    }

    @PostMapping("/notes")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Note create(@RequestBody Note note) {
        this.logger.info("create note: {}", note);
        return noteRepository.save(note);
    }

    @DeleteMapping("/notes/{id}")
    public void destory(@PathVariable("id") String id, HttpServletResponse response) {
        this.logger.info("destory note: {}", id);

        boolean exist =  noteRepository.existsById(id);
        if (!exist) {
            this.logger.info("note {} not exist", id);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }

        noteRepository.deleteById(id);
    }
}
