package com.example.android_finals.activities.com.example.android_finals.view.fragments

import androidx.fragment.app.Fragment
import com.example.android_finals.R
import com.example.android_finals.databinding.FragmentFavoriteItemsBinding
import com.example.android_finals.model.dao.ItemDao

class FavoriteItemsFragment(
    itemDao: ItemDao
) : Fragment(R.layout.fragment_favorite_items) {
    private var _binding: FragmentFavoriteItemsBinding? = null
    private val binding: FragmentFavoriteItemsBinding get() = _binding!!

    companion object{
        fun newInstance() = FavoriteItemsFragment
    }
}
