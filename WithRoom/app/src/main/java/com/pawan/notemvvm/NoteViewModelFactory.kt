package com.pawan.notemvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pawan.notemvvm.repository.NotesRepo
import java.lang.IllegalArgumentException

class NoteViewModelFactory(private val notesRepo: NotesRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotesViewModel::class.java)){
            return NotesViewModel(notesRepo) as T
        }
        throw IllegalArgumentException("ViewModel Error")
    }
}