package com.hfad.motivation

class FavoritesRepository(
    private val database: FavoritesDatabase
) {

    suspend fun addToFavorites(quote: MutableList<QuotesDataClass>){
        database.dao().addToFavorites(quote)
    }
    fun getAllQuotes() {
        database.dao().getAllFavorites()
    }
    suspend fun deleteFavorites(quote: QuotesDataClass){
        database.dao().removeFromFavorites(quote)
    }
}