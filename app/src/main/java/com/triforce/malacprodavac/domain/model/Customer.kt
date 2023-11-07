package com.triforce.malacprodavac.domain.model

data class Customer(
    val id: Int,
    val userId: Int,
    val favoriteProducts: List<Int>,
    val favoriteShops: List<Int>,
    val createdAt: String,
    val updatedAt: String,

    val user: User?,
)