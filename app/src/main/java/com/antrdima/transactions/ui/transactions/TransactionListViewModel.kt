package com.antrdima.transactions.ui.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.antrdima.transactions.TransactionsApp
import com.antrdima.transactions.data.TransactionRepository
import com.antrdima.transactions.data.toTransactionUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransactionListViewModel(private val repository: TransactionRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                while (true) {
                    repository.refreshTransactions()
                    delay(10000)
                }
            }
        }
    }

    val transactions =
        repository.getAllTransactions()
            .map { list -> list.map { it.toTransactionUi() } }
            .transform { list -> emit(list.groupBy { it.time }) }
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyMap())

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = (this[APPLICATION_KEY] as TransactionsApp).transactionRepository
                TransactionListViewModel(repository)
            }
        }
    }
}