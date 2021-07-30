package com.pawan.notemvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawan.notemvvm.databinding.ActivityMainBinding
import com.pawan.notemvvm.db.NoteModel
import com.pawan.notemvvm.db.NotesDAO
import com.pawan.notemvvm.db.NotesDatabase
import com.pawan.notemvvm.repository.NotesRepo

class MainActivity : AppCompatActivity(), NotesRecyclerViewClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteViewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Step 1: Perform Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Step 2: Since activity interact with viewModel so create instance of viewModel
        //but viewModel depends on NoteRepo so create NoteRepo (by providing DAO)
        val dao: NotesDAO = NotesDatabase.getInstance(context = applicationContext).notesDao
        val repository = NotesRepo(dao)

        //Since view model needs repo instance in constructor so we are using view model factory
        val factory = NoteViewModelFactory(repository)
        noteViewModel = ViewModelProvider(this, factory).get(NotesViewModel::class.java)


        binding.noteVieModel = noteViewModel
        binding.lifecycleOwner = this
        displayAllNotes()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.notesRecyclerView.layoutManager = LinearLayoutManager(this)
        displayAllNotes()
    }

    private fun displayAllNotes() {
        noteViewModel.allNotes.observe(this, Observer {
            Log.i("TAG", it.toString())
            binding.notesRecyclerView.adapter = NoteRecyclerViewAdapter(it, this)
        })


    }

    override fun onRecyclerViewNoteClicked(view: View, note: NoteModel) {
        when (view.id) {
            R.id.note_item -> {
                Toast.makeText(this, note.detail, Toast.LENGTH_LONG).show()
                noteViewModel.initUpdateAndDelete(note)
            }
        }
    }


}