package com.example.android_finals.model.api

import com.example.android_finals.model.entity.Item
import retrofit2.Call
import retrofit2.http.GET

interface ItemApi {

    @GET("products")
    fun fetchAllItems(): Call<List<Item>>
}

