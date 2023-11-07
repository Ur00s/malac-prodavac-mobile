package com.triforce.malacprodavac.domain.model

data class CreateShop(
    val user: CreateUser,
    val businessName: String? = null
)
