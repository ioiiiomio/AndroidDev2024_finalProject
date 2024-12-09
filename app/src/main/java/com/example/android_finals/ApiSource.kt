package com.example.android_finals

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiSource {

    private val gson = Gson()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    val client = retrofit.create(ItemApi::class.java)
}