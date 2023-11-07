package com.triforce.malacprodavac.domain.repository

import com.triforce.malacprodavac.domain.model.CreateShop
import com.triforce.malacprodavac.domain.model.Shop
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    suspend fun registerShop(
        createShop: CreateShop
    ): Flow<Resource<Shop>>
}