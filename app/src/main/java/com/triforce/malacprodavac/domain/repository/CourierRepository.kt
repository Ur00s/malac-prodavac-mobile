package com.triforce.malacprodavac.domain.repository

import com.triforce.malacprodavac.domain.model.Courier
import com.triforce.malacprodavac.domain.model.CreateCourier
import com.triforce.malacprodavac.util.Resource
import kotlinx.coroutines.flow.Flow

interface CourierRepository {
    suspend fun registerCourier(
        createCourier: CreateCourier
    ): Flow<Resource<Courier>>
}