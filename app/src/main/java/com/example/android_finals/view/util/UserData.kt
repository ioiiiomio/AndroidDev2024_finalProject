package com.example.android_finals.view.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class UserData(context: Context) {

    companion object {
        private const val AUTHORIZATION_PREFERENCE = "com.example.demo.authorization"
        private const val IS_AUTHORIZED = "isAuthorized"
        private const val USERNAME_KEY = "username"
    }

    private val preferences: SharedPreferences = context.getSharedPreferences(
        AUTHORIZATION_PREFERENCE, Context.MODE_PRIVATE)

    fun isAuthorized() = preferences.getBoolean(IS_AUTHORIZED, false)

    fun setAuthorizationState(isAuthorized: Boolean) = preferences.edit {
        putBoolean(IS_AUTHORIZED, isAuthorized)
    }

    fun setUsername(username: String) = preferences.edit {
        putString(USERNAME_KEY, username)
    }

    fun getUsername(): String? = preferences.getString(USERNAME_KEY, null)
}
