package com.triforce.malacprodavac.domain.model


data class Shop(
    val id: Int,
    val userId: Int,
    val businessName: String?,
    val createdAt: String,
    val updatedAt: String,

    val user: User?
)