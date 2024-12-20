package com.example.android_finals.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_finals.databinding.ItemCardBinding
import com.example.android_finals.model.entity.Item
import retrofit2.Call

class ItemCardAdapter : ListAdapter<Item, ItemCardAdapter.ViewHolder>(ItemCardCallback()) {

    private var originalList: List<Item> = emptyList()

    inner class ViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            with(binding) {
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

    //сохраняем исходный список в переменной чтобы при выборе категорий фильтровать этот исходный список
    fun updateList(items: List<Item>) {
        originalList = items
        submitList(emptyList())
    }

    // фильтруем и показываем только нужную категорию, не меняя исходный список
    fun filterItems(category: String) {
        val filteredList = originalList.filter { it.category.equals(category, ignoreCase = true) }
        submitList(filteredList)
    }
}