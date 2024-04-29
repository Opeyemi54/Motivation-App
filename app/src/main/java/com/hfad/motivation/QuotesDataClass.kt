package com.hfad.motivation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_table")
 class QuotesDataClass(

     @PrimaryKey(autoGenerate = true)  val id : Int,
     val quotesText: String,
     val quotesAuthor:String
) {
     fun getQuote(): String {
         return quotesText
     }

     fun getWriter(): String {
         return quotesAuthor
     }

    fun getInt():Int {
        return id
    }

 }