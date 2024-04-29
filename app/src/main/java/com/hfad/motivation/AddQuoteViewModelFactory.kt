package com.hfad.motivation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddQuoteViewModelFactory(val app:Application, private val repository: QuoteRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddQuoteViewModel(app, repository) as T

    }
}