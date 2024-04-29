package com.hfad.motivation

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(entities = [Quote::class], version = 1, exportSchema = false)
 abstract class QuoteDataBase : RoomDatabase() {
     abstract fun getQuoteDao(): QuoteDao

     companion object {
         @Volatile
         private var instance : QuoteDataBase? = null

         private val Lock = Any()

         operator fun invoke(context: Context) = instance?:
         synchronized(Lock){
             instance ?:
             createDatabase(context).also{
                 instance = it
             }
         }

         private fun createDatabase(context: Context) =
             Room.databaseBuilder(
                 context.applicationContext,
                 QuoteDataBase::class.java,
                 "name"
             ).build()


     }

}