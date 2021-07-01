package com.pawan.notemvvm

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pawan.notemvvm.repository.NotesRepo

class NotesViewModel(private val notesRepo: NotesRepo) : ViewModel() {
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
        deleteOrClearBtn.value = "Delete"
    }

    fun saveOrUpdateNote(){

    }

    fun deleteOrClear(){

    }

    fun  deleteAllNotes(){

    }

}