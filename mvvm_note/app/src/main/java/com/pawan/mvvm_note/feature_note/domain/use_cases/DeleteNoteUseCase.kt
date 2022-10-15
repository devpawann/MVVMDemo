package com.pawan.mvvm_note.feature_note.domain.use_cases

import com.pawan.mvvm_note.feature_note.domain.model.Note
import com.pawan.mvvm_note.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}