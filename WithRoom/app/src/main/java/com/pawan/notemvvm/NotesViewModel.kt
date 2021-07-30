package com.pawan.notemvvm

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pawan.notemvvm.db.NoteModel
import com.pawan.notemvvm.db.NotesDAO
import com.pawan.notemvvm.repository.NotesRepo
import kotlinx.coroutines.launch

class NotesViewModel(private val notesRepo: NotesRepo) : ViewModel(), Observable {

    val allNotes = notesRepo.allNotes
    private var isUpdateOrDelete = false
    private lateinit var noteModelToUpdateOrDelete: NoteModel

    @Bindable
    val noteTitle = MutableLiveData<String>()

    @Bindable
    val noteBody = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateBtn = MutableLiveData<String>()

    @Bindable
    val deleteOrClearBtn = MutableLiveData<String>()

    @Bindable
    val deleteAllBtn = MutableLiveData<String>()

    init {
        saveOrUpdateBtn.value = "Save"
        deleteOrClearBtn.value = "Clear"
        deleteAllBtn.value = "Delete All"

    }

    fun saveOrUpdateNote() {
        val title = noteTitle.value!!
        val body = noteBody.value!!
        val note: NoteModel = NoteModel(0, title, body)

        if (isUpdateOrDelete) {
            updateNote(note)
        }

        insertNote(note)
        noteTitle.value = ""
        noteBody.value = ""

        isUpdateOrDelete=false
    }

    fun deleteOrClear() {
        if (isUpdateOrDelete) {
            deleteNote(noteModelToUpdateOrDelete)
        }
        deleteAllNotes()

        noteTitle.value = ""
        noteBody.value = ""

        isUpdateOrDelete=false
    }

    fun deleteAllNotes() {
        deleteAllNote()
    }

    private fun insertNote(note: NoteModel) {
        viewModelScope.launch {

            notesRepo.insertNote(note)
        }
    }

    fun updateNote(note: NoteModel) {
        viewModelScope.launch {
            notesRepo.updateNote(note)
        }
    }

    private fun deleteNote(note: NoteModel) {
        viewModelScope.launch {
            notesRepo.deleteNote(note)
        }
    }

    private fun deleteAllNote() {
        viewModelScope.launch {
            notesRepo.deleteAllNotes()
        }
    }

    fun initUpdateAndDelete(note: NoteModel) {
        noteTitle.value = note.title
        noteBody.value = note.detail

        isUpdateOrDelete = true
        noteModelToUpdateOrDelete = note

        saveOrUpdateBtn.value = "Update"
        deleteOrClearBtn.value = "Delete"

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}