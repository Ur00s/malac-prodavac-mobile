package com.triforce.malacprodavac.domain.model

data class Category(
    val id: Int,
    val name: String,
    val parentCategoryId: Int?,
    val updatedAt: String,
    val createdAt: String
)
