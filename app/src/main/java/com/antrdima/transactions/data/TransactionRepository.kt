package com.antrdima.transactions.data

import com.antrdima.transactions.data.local.Transaction
import com.antrdima.transactions.data.local.TransactionDao
import com.antrdima.transactions.data.remote.TransactionsService
import kotlinx.coroutines.flow.Flow

class TransactionRepository(
    private val transactionDao: TransactionDao,
    private val apiService: TransactionsService
) {

    fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    suspend fun refreshTransactions() {
        val newTransactions = apiService.getTransactions()
        transactionDao.insertTransactions(newTransactions)
    }
}