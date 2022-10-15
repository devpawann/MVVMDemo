package com.pawan.mvvm_note.feature_note.domain.use_cases

import com.pawan.mvvm_note.feature_note.domain.model.InvalidNoteException
import com.pawan.mvvm_note.feature_note.domain.model.Note
import com.pawan.mvvm_note.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Body can't be empty")
        }
        repository.insertNote(note);
    }
}