package com.hfad.motivation

class QuoteRepository(private val db: QuoteDataBase) {
    suspend fun insertQuote(quote: Quote) = db.getQuoteDao().insertQuote(quote)

    suspend fun deleteTask(quote: Quote)= db.getQuoteDao().deleteQuote(quote)

    suspend fun updateTask(quote: Quote)= db.getQuoteDao().updateQuote(quote)

    fun getAllTasks() = db.getQuoteDao().getAllQuote()



}