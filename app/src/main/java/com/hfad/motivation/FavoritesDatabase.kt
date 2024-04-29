package com.hfad.motivation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuotesDataClass::class], version = 1, exportSchema = false)

abstract class FavoritesDatabase  : RoomDatabase(){

    abstract fun dao(): Dao

    companion object {
        private const val DATABASE_NAME = "quote_database.db"
        @Volatile
        private var INSTANCE: FavoritesDatabase? = null

        fun getInstance(context: Context): FavoritesDatabase{
            if (INSTANCE == null){
                synchronized(FavoritesDatabase::class.java){
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            FavoritesDatabase::class.java, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}