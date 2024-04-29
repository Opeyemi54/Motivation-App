package com.hfad.motivation

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(quote: MutableList<QuotesDataClass>)

    @Delete
    suspend fun removeFromFavorites(quote: QuotesDataClass)

    @Query("SELECT * FROM favorite_table ORDER BY id DESC")
     fun getAllFavorites(): List<QuotesDataClass>
}