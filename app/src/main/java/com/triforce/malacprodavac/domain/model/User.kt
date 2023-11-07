package com.triforce.malacprodavac.domain.model

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val address: String?,
    val addressLatitude: Double?,
    val addressLongitude: Double?,
    val currency: String,
    val paymentMethod: String,
    val phoneNumber: String?,
    val roles: List<String>,
    val updatedAt: String,
    val createdAt: String,

    val customer: Customer?,
    val shop: Shop?,
    val courier: Courier?,
)