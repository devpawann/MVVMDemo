package com.pawan.notemvvm.repository

import com.pawan.notemvvm.db.NoteModel
import com.pawan.notemvvm.db.NotesDAO

class NotesRepo(private val notesDAO: NotesDAO) {
    val allNotes = notesDAO.fetchAllNotes()

    suspend fun insertNote(note: NoteModel) {
        notesDAO.insertNote(note)
    }

    suspend fun updateNote(note: NoteModel) {
        notesDAO.updateNote(note)
    }
    suspend fun deleteNote(note: NoteModel) {
        notesDAO.deleteNote(note)
    }

    suspend fun deleteAllNotes(){
        notesDAO.deleteAllNotes()
    }
}