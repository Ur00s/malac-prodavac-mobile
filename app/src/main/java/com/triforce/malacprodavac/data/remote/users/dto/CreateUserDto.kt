package com.triforce.malacprodavac.data.remote.users.dto

data class CreateUserDto(
    val currency: String? = "RSD",
    val paymentMethod: String? = "onDelivery",
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val address: String? = null,
    val addressLatitude: Int? = 0,
    val addressLongitude: Int? = 0,
    val phoneNumber: String? = ""
)
