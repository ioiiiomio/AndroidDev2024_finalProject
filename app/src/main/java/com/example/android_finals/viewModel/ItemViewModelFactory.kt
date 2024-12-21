package com.example.android_finals.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_finals.App
import com.example.android_finals.model.api.ApiSource

class ItemViewModelFactory :ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(
            client = ApiSource.client,
            itemDao = App.datadase.itemDao()
        ) as T
    }
}