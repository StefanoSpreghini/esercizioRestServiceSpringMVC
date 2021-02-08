package com.example.accessingdatamysqlnote;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysqlnote.Note;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NoteRepository extends CrudRepository<Note, Integer> {

}