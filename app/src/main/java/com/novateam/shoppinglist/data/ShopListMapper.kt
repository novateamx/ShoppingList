package com.novateam.shoppinglist.data

import com.novateam.shoppinglist.data.room.ShopItemDbModule
import com.novateam.shoppinglist.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDbModule(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDbModelToEntity(shopItemDbModule: ShopItemDbModule) = ShopItem(
        id = shopItemDbModule.id,
        name = shopItemDbModule.name,
        count = shopItemDbModule.count,
        enabled = shopItemDbModule.enabled
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDbModule>) = list.map {
        mapDbModelToEntity(it)
    }
}