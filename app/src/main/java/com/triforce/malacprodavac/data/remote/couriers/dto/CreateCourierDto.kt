package com.triforce.malacprodavac.data.remote.couriers.dto

import com.triforce.malacprodavac.domain.model.CreateUser

data class CreateCourierDto(
    val user: CreateUser,
    val pricePerKilometer: Double?
)
