package com.triforce.malacprodavac.data.remote.shops

import com.triforce.malacprodavac.data.remote.Api
import com.triforce.malacprodavac.data.remote.shops.dto.CreateShopDto
import com.triforce.malacprodavac.domain.model.Shop
import retrofit2.http.Body
import retrofit2.http.POST

interface ShopsApi {
    @POST(ROUTE)
    suspend fun registerShop(
        @Body registerRequest: CreateShopDto
    ): Shop
    companion object{
        const val ROUTE="/shops"
    }
}