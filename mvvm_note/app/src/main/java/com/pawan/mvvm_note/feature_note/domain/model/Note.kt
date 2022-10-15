package com.pawan.mvvm_note.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pawan.mvvm_note.ui.theme.*
import java.lang.Exception
import java.util.*

@Entity
data class Note(
    val title:String,
    val content:String,
    val timeStamp:Long,
    val color:Int,
    @PrimaryKey
    val id:Int
){
    companion object{
        val noteColors= listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class  InvalidNoteException(message:String):Exception(message){}