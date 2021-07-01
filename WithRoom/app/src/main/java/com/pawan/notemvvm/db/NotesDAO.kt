package com.pawan.notemvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteModel)

    @Update
    suspend fun updateNote(note: NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)

    //Query will be verified at compile time so no errors at runtime

    //Room provides data in the form of live data

    @Query("Select * from notes_table")
    fun fetchAll(): LiveData<NoteModel>
}