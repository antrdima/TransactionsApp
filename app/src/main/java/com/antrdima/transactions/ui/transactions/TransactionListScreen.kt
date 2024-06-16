package com.antrdima.transactions.ui.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.antrdima.transactions.data.TransactionUi
import com.antrdima.transactions.data.local.TransactionStatus
import com.antrdima.transactions.data.local.TransactionType

@Composable
fun TransactionListScreen(viewModel: TransactionListViewModel, modifier: Modifier) {
    val transactions = viewModel.transactions.collectAsState(initial = emptyMap())
    val listState = rememberLazyListState()

    LazyColumn(state = listState, modifier = modifier) {
        transactions.value.forEach { (time, transactions) ->
            item {
                Text(
                    text = time,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }
            items(transactions) {
                TransactionItem(it)
            }
            item {
                HorizontalDivider(color = Color.Black)
            }
        }
    }
}

@Composable
fun TransactionItem(transactionUi: TransactionUi) {
    Row(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        TypeIcon(type = transactionUi.type)
        Text(text = transactionUi.type.name, modifier = Modifier.weight(1f))
        StatusIcon(status = transactionUi.status)
        Text(text = "${transactionUi.amount}", modifier = Modifier.weight(1f))
        Text(text = transactionUi.dateTime, modifier = Modifier.weight(2f))
    }
}

@Composable
fun TypeIcon(type: TransactionType) {
    when (type) {
        TransactionType.CASH -> Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
        TransactionType.CARD -> Icon(
            imageVector = Icons.Rounded.DateRange,
            contentDescription = null
        )

        TransactionType.BANK -> Icon(
            imageVector = Icons.Rounded.LocationOn,
            contentDescription = null
        )

        TransactionType.CARD_TO_CARD -> Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null
        )
    }
}

@Composable
fun StatusIcon(status: TransactionStatus) {
    when (status) {
        TransactionStatus.IN_PROGRESS -> Icon(
            imageVector = Icons.Rounded.Refresh,
            contentDescription = null
        )

        TransactionStatus.SUCCESS -> Icon(
            imageVector = Icons.Rounded.Done,
            contentDescription = null
        )

        TransactionStatus.FAILURE -> Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = null
        )
    }
}