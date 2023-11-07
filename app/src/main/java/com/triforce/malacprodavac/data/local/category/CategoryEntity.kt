package com.triforce.malacprodavac.data.local.category

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = CategoryEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("parentCategoryId")
)])
data class CategoryEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val parentCategoryId: Int?,
    val updatedAt: String,
    val createdAt: String
)
