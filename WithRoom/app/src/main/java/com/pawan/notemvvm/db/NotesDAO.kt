package com.pawan.notemvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface  NotesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteModel)

    @Update
    suspend fun updateNote(note: NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)

    //Query will be verified at compile time so no errors at runtime
    //Room provides data in the form of live data

    //Those fcn with live data as return type
    //Room will handle this by itself in bg thread so no need to make it suspend function
    @Query("Select * from notes_table")
    fun fetchAllNotes(): LiveData<List<NoteModel>>

    @Query("delete from notes_table")
    suspend fun deleteAllNotes():Int
}

