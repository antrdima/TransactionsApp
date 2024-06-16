package com.antrdima.transactions.di

import android.content.Context
import com.antrdima.transactions.data.TransactionRepository
import com.antrdima.transactions.data.local.TransactionsDatabase
import com.antrdima.transactions.data.remote.RetrofitClient

object ServiceLocator {

    @Volatile
    var transactionRepository: TransactionRepository? = null

    fun provideTransactionRepository(context: Context): TransactionRepository{
        synchronized(this) {
            return transactionRepository ?: transactionRepository ?: createTransactionRepository(context)
        }
    }

    private fun createTransactionRepository(context: Context): TransactionRepository{
        val transactionDao = TransactionsDatabase.getDatabase(context).transactionDao()
        val apiService = RetrofitClient.apiService
        val repository = TransactionRepository(transactionDao, apiService)
        return repository
    }
}