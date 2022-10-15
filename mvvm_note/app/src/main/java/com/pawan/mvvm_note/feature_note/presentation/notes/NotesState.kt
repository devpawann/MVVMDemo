package com.pawan.mvvm_note.feature_note.presentation.notes

import com.pawan.mvvm_note.feature_note.domain.model.Note
import com.pawan.mvvm_note.feature_note.domain.utils.NoteOrder
import com.pawan.mvvm_note.feature_note.domain.utils.OrderType

data class NotesState(
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder=NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean=false,
)
