package com.antrdima.transactions

import android.app.Application
import com.antrdima.transactions.data.TransactionRepository
import com.antrdima.transactions.di.ServiceLocator

class TransactionsApp : Application() {

    val transactionRepository: TransactionRepository
        get() = ServiceLocator.provideTransactionRepository(this)
}