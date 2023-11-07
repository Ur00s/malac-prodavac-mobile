package com.triforce.malacprodavac.domain.model

data class CreateCourier(
    val user: CreateUser,
    val pricePerKilometer: Double? = null
)
