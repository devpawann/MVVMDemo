package com.pawan.notemvvm

import android.view.View
import com.pawan.notemvvm.db.NoteModel

interface NotesRecyclerViewClickListener {

    fun onRecyclerViewNoteClicked(view: View, note: NoteModel)
}