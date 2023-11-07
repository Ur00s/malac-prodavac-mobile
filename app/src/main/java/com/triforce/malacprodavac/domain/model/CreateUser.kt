package com.triforce.malacprodavac.domain.model

data class CreateUser(
    val currency: String? = "RSD",
    val paymentMethod: String? = "OnDelivery",
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val address: String? = null,
    val addressLatitude: Int? = 0,
    val addressLongitude: Int? = 0,
    val phoneNumber: String? = null
)
