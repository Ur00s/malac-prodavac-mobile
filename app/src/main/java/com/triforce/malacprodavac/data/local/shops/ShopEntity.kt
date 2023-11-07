package com.triforce.malacprodavac.data.local.shops

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.triforce.malacprodavac.data.local.user.UserEntity

@Entity(foreignKeys = [ForeignKey(
    entity = UserEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("userId")
)])
data class ShopEntity(
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val businessName: String,
    val createdAt: String,
    val updatedAt: String,
)
