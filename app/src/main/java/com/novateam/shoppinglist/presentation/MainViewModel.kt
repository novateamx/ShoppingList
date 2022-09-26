package com.novateam.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.novateam.shoppinglist.data.ShopListRepositoryImpl
import com.novateam.shoppinglist.domain.DeleteShopItemUseCase
import com.novateam.shoppinglist.domain.EditShopItemUseCase
import com.novateam.shoppinglist.domain.GetShopListUseCase
import com.novateam.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}