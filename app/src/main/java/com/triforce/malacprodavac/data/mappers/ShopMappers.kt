package com.triforce.malacprodavac.data.mappers

import com.triforce.malacprodavac.data.local.shops.ShopEntity
import com.triforce.malacprodavac.domain.model.Shop

fun ShopEntity.toShop(): Shop = Shop(
    id = id,
    userId = userId,
    businessName = businessName,
    createdAt = createdAt,
    updatedAt = updatedAt,

    user = null
)