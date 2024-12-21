package com.example.android_finals.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_finals.model.entity.ItemEntity

@Dao
interface ItemDao {
    @Query("SELECT * FROM favourite_items")
    suspend fun getAllItems(): List<ItemEntity>

    @Insert
    suspend fun insert(item: ItemEntity)
}