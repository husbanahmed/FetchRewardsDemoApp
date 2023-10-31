package com.example.fetchcodingexercise.network

import com.example.fetchcodingexercise.model.ItemApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    /**
     * Creates a local retrofit instance with access to [ItemApi]
     */
    val api: ItemApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ItemApi::class.java)
    }
}