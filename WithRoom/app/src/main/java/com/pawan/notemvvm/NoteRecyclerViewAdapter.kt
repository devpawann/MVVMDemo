package com.pawan.notemvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pawan.notemvvm.databinding.NoteItemBinding
import com.pawan.notemvvm.db.NoteModel

class NoteRecyclerViewAdapter(
    private val notes: List<NoteModel>,
    private val listener: NotesRecyclerViewClickListener
) :
    RecyclerView.Adapter<NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: NoteItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.note_item, parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notes[position])

        holder.noteItemBinding.root.setOnClickListener {
            listener.onRecyclerViewNoteClicked(holder.noteItemBinding.root, notes[position])
        }


    }

    override fun getItemCount() = notes.size
}

class NotesViewHolder(val noteItemBinding: NoteItemBinding) :
    RecyclerView.ViewHolder(noteItemBinding.root) {

    fun bind(note: NoteModel) {
        noteItemBinding.noteTitle.text = note.title
        noteItemBinding.noteBody.text = note.detail
    }
}