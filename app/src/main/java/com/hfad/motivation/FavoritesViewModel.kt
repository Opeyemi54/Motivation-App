package com.hfad.motivation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FavoritesViewModel(app: Application, private val repository: FavoritesRepository): ViewModel() {
    fun addToFavorites(quote: MutableList<QuotesDataClass>){
        viewModelScope.launch {
            repository.addToFavorites(quote)
        }
    }
    fun getAllQuotes() {
        viewModelScope.launch {
            repository.getAllQuotes()
        }
    }

    fun removeFromFavorites(quote: QuotesDataClass){
        viewModelScope.launch {
            repository.deleteFavorites(quote)
        }
    }
}