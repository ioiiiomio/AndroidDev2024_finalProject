package com.example.android_finals

import androidx.recyclerview.widget.DiffUtil.ItemCallback

class ItemCardCallback : ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}