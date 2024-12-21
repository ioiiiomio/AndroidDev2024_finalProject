package com.example.android_finals.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_items")
data class ItemEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
) {
    companion object {
        fun from(item: Item): ItemEntity {
            return ItemEntity(
                id = item.id,
                title = item.title,
                price = item.price,
                description = item.description,
                category = item.category,
                image = item.image
            )
        }

    }
}


