package com.triforce.malacprodavac.data.remote.shops.dto

import com.triforce.malacprodavac.domain.model.CreateUser

data class CreateShopDto(
    val user: CreateUser,
    val businessName: String?
)
