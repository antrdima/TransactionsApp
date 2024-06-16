package com.antrdima.transactions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.antrdima.transactions.ui.theme.TransactionsTheme
import com.antrdima.transactions.ui.transactions.TransactionListScreen
import com.antrdima.transactions.ui.transactions.TransactionListViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: TransactionListViewModel by viewModels { TransactionListViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransactionsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TransactionListScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}