package com.antrdima.transactions.data.remote

import com.antrdima.transactions.data.local.Transaction
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface TransactionsService {
    @GET("dummy/transaction")
    suspend fun getTransactions(): List<Transaction>
}

object RetrofitClient {
    private const val BASE_URL = "https://racoon.zoomag.ru/"

    val apiService: TransactionsService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TransactionsService::class.java)
    }
}