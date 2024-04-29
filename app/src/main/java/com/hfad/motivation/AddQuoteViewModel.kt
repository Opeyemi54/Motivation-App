package com.hfad.motivation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AddQuoteViewModel(app: Application, private val taskRepository: QuoteRepository):AndroidViewModel(app) {

    fun addQuote(quote: Quote)=
        viewModelScope.launch {
            taskRepository.insertQuote(quote)
        }

    fun deleteQuote(quote: Quote) =
        viewModelScope.launch {
            taskRepository.deleteTask(quote)
        }

    fun updateQuote(quote: Quote) =
        viewModelScope.launch {
            taskRepository.updateTask(quote)
        }

    fun getAllQuote() = taskRepository.getAllTasks()


}