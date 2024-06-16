package com.antrdima.transactions.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey val id: String,
    val type: TransactionType,
    val status: TransactionStatus,
    val amount: Double,
    @SerializedName("created") val timestamp: Long
)

enum class TransactionType {
    CASH, CARD, BANK, CARD_TO_CARD
}

enum class TransactionStatus {
    IN_PROGRESS, SUCCESS, FAILURE
}