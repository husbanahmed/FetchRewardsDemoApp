package com.example.fetchcodingexercise.model

import retrofit2.Response
import retrofit2.http.GET

interface ItemApi {
    /**
     * @return Returns a list of [Item]
     */
    @GET("hiring.json")
    suspend fun getItems(): Response<List<Item>>
}