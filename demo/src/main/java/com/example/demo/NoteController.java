package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {
    private final NoteRepository noteRepository;

    NoteController(NoteRepository repository) {
        this.noteRepository = repository;
    }

    @GetMapping("/notes")
    Iterable<Note> getNotes() {
        return noteRepository.findAll();
    }

    @PostMapping("/notes")
    Note createNote(@RequestBody Note newNote) {
        return noteRepository.save(newNote);
    }

    @GetMapping("/note/{id}")
    Note getNote(@PathVariable Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

    @PutMapping("/notes/{id}")
    Note updateNote(@PathVariable Long id, @RequestBody Note noteDto) {
        Note noteToUpdate = noteRepository.findById(id).orElseThrow();
        noteToUpdate.setTitle(noteDto.getTitle());
        noteToUpdate.setContent(noteDto.getContent());
        return noteRepository.save(noteToUpdate);
    }

    @DeleteMapping("note/{id}")
    void deleteNote(@PathVariable Long id) {
        Note note = noteRepository.findById(id).orElseThrow();
        noteRepository.delete(note);
    }
}
