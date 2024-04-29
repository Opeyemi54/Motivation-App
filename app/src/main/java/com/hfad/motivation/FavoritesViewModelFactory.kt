package com.hfad.motivation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FavoritesViewModelFactory( val app: Application, private val repository:FavoritesRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            return FavoritesViewModel( app, repository) as T
        }
         throw IllegalArgumentException("Unknown ViewModel")

    }
}