package com.antrdima.transactions.data

import com.antrdima.transactions.core.toFormattedDateTime
import com.antrdima.transactions.core.toFormattedTime
import com.antrdima.transactions.data.local.Transaction
import com.antrdima.transactions.data.local.TransactionStatus
import com.antrdima.transactions.data.local.TransactionType

data class TransactionUi(
    val id: String,
    val type: TransactionType,
    val status: TransactionStatus,
    val amount: Double,
    val time: String,
    val dateTime: String
)

fun Transaction.toTransactionUi() = TransactionUi(
    this.id,
    this.type,
    this.status,
    this.amount,
    this.timestamp.toFormattedTime(),
    this.timestamp.toFormattedDateTime()
)