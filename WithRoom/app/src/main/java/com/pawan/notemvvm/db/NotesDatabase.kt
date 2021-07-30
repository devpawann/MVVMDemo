package com.pawan.notemvvm.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [NoteModel::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract val notesDao: NotesDAO

    //To use singleton pattern
    //TODO Use Object to reduce this boilerplate code
    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null
        fun getInstance(context: Context): NotesDatabase {

            //Synchronized will help to make sure no two thread can access this at a time
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(
                            context,
                            NotesDatabase::class.java,
                            "Notes_database"
                        ).build()
                }
                return instance
            }

        }
    }
}

