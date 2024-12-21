package com.example.android_finals.model.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

data class RegisterRequest(
    val username: String,
    val password: String
)

data class RegisterResponse(
    val id: String, // ID assigned by the server
    val username: String,
)

interface ApiService {
    @POST("users")
    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>
}
