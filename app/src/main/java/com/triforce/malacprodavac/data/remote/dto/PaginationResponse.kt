package com.triforce.malacprodavac.data.remote.dto

import com.squareup.moshi.Json
import com.triforce.malacprodavac.data.local.category.CategoryEntity

data class PaginationResponse (
    @Json(name = "data")
    val data: List<CategoryEntity>
)