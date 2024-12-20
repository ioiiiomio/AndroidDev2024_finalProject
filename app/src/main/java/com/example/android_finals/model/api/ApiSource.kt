package com.example.android_finals.model.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiSource {

    private val gson = Gson()

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // Set the connection timeout
        .readTimeout(30, TimeUnit.SECONDS)    // Set the read timeout
        .writeTimeout(30, TimeUnit.SECONDS)   // Set the write timeout
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    val client = retrofit.create(ItemApi::class.java)
}