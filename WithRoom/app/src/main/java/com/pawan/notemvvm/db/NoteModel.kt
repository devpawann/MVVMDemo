package com.pawan.notemvvm.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val detail: String
)