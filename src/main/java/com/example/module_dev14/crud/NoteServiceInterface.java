package com.example.module_dev14.crud;

import com.example.module_dev14.entity.Note;

import java.util.List;

public interface NoteServiceInterface {
    List<Note> listAll();

    Note add(Note note);

    void deleteById(long id);

    void update(Note note);

    Note getById(long id);
}
