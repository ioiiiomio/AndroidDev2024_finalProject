package com.example.android_finals.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_finals.model.api.ItemApi
import com.example.android_finals.model.dao.ItemDao
import com.example.android_finals.model.entity.Item
import com.example.android_finals.model.entity.ItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call

class ItemViewModel(
    private val client: ItemApi,
    private val itemDao: ItemDao
) : ViewModel() {
    private val _itemsListUI = MutableLiveData<ItemListUI>()
    val itemsListUI: LiveData<ItemListUI> get() = _itemsListUI

    fun changeFavouriteState(item: Item, isFavourite : Boolean) {
        viewModelScope.launch {
            if (isFavourite){
                itemDao.insert(ItemEntity.from(item))
            }
        }
    }

    fun fetchItems() {
        _itemsListUI.value = ItemListUI.Loading(true)

        viewModelScope.launch {
            println("Room db: ${itemDao.getAllItems()}")
            try {
                val itemList = client.fetchAllItems()

                _itemsListUI.value = ItemListUI.Success(itemList)
            } catch (e: Exception) {
                _itemsListUI.value = ItemListUI.Error("Error fetching items: ${e.message}")
            }
            _itemsListUI.value = ItemListUI.Loading(false)
        }
    }


}

sealed interface ItemListUI{
    data class Loading(val isLoading: Boolean) : ItemListUI
    data class Success(val items: List<Item>) : ItemListUI
    data class Error(val message: String) : ItemListUI
    data object Empty : ItemListUI
}