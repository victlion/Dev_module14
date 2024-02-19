package com.example.module_dev14.crud;

import com.example.module_dev14.entity.Note;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class NoteRepository{
    private List<Note> notes = new ArrayList<>();
    private long id = 0;

    public Note add(Note note) {
        note.setId(id++);
        notes.add(note);
        return note;
    }
    public Iterable<Note> getAll() {
        return notes;
    }

    public void deleteById(long id) {
        Note existingNote = getById(id);
        notes.remove(existingNote);
    }

    public void update(Note note) {
        Note existingNote = getById(note.getId());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found."));
    }
}