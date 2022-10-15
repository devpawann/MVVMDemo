package com.pawan.mvvm_note.feature_note.domain.use_cases


/**
This is just an [ wrapper] class on top of all the use cases
This is done as it will reduce the constructor or parameters
*/

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNote: AddNoteUseCase
)