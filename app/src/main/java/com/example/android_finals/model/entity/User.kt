package com.example.android_finals.model.entity

data class User(
    val id: Int,
    val username: String,
    val password: String // Avoid storing plaintext passwords; use hashing in real-world apps
)

data class RegisterRequest(
    val username: String,
    val password: String
)

data class RegisterResponse(
    val success: Boolean,
    val message: String
)
