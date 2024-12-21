package com.example.android_finals.model.db

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.android_finals.model.dao.ItemDao
import com.example.android_finals.model.entity.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}