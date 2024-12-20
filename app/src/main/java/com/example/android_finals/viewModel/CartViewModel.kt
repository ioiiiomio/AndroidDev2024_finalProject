package com.example.android_finals.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_finals.model.entity.CartItem

class CartViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<MutableList<CartItem>>(mutableListOf())
    val cartItems: LiveData<MutableList<CartItem>> = _cartItems

    // Add item to the cart
    fun addItemToCart(item: CartItem) {
        val updatedCartItems = _cartItems.value
        updatedCartItems?.add(item)
        _cartItems.value = updatedCartItems
    }
}
