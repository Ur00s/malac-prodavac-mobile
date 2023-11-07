package com.triforce.malacprodavac.data.mappers

import com.triforce.malacprodavac.data.local.category.CategoryEntity
import com.triforce.malacprodavac.domain.model.Category

fun CategoryEntity.toCategory(): Category = Category(
    id = id,
    name = name,
    parentCategoryId = parentCategoryId,
    updatedAt = updatedAt,
    createdAt = createdAt
)
