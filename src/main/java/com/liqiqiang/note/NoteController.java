package com.liqiqiang.note;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> index() {
        return this.noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> show(@PathVariable("id") String id) {
        return this.noteRepository.findById(id);
    }

    // @PostMapping("/notes")
    // public Note create(@RequestBody Note note) {
    //     note = this.noteRepository.save(note);
    //     return note;
    // }
}
