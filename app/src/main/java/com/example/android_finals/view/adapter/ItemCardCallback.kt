package com.example.android_finals.view.adapter

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.example.android_finals.model.entity.Item

class ItemCardCallback : ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}