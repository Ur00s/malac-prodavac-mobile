package com.triforce.malacprodavac.data.remote.couriers

import com.triforce.malacprodavac.data.remote.Api
import com.triforce.malacprodavac.data.remote.couriers.dto.CreateCourierDto
import com.triforce.malacprodavac.domain.model.Courier
import retrofit2.http.Body
import retrofit2.http.POST

interface CouriersApi {
    @POST(ROUTE)
    suspend fun registerCouriers(
        @Body registerRequest: CreateCourierDto
    ): Courier

    companion object {
        const val ROUTE = "/couriers"
    }
}