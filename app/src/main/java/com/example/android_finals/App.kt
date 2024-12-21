package com.example.android_finals

import android.app.Application
import androidx.room.Room
import com.example.android_finals.model.db.AppDataBase

class App : Application() {

    companion object{
        lateinit var datadase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()

        datadase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "app_database"
        ).build()

    }
}