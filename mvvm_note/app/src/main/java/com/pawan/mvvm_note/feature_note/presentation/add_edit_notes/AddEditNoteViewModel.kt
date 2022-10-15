package com.pawan.mvvm_note.feature_note.presentation.add_edit_notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pawan.mvvm_note.feature_note.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(private val noteUseCases: NoteUseCases) :
    ViewModel() {

        private val _noteTitle = mutableStateOf("")
        val noteTitle: State<String> = _noteTitle

    }

