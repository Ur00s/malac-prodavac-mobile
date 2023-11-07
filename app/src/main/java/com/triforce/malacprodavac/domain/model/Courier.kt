package com.triforce.malacprodavac.domain.model

data class Courier(
    val id: Int,
    val userId: Int,
    val currentLocation: String,
    val currentLocationLatitude: Double?,
    val currentLocationLongitude: Double?,
    val pricePerKilometer: Double?,
    val updatedAt: String,
    val createdAt: String,

    val user:User?
)