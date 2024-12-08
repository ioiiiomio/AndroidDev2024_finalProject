package com.example.android_finals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_finals.databinding.ItemCardBinding

class ItemCardAdapter : ListAdapter<Item, ItemCardAdapter.ViewHolder>(ItemCardCallback()) {

    inner class ViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            with(binding){
                title.text = item.title
                detailName.text = item.description
                detailPrice.text = "$ ${item.price}"
                Glide.with(itemView.context)
                    .load(item.image)
                    .into(detailImage)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}