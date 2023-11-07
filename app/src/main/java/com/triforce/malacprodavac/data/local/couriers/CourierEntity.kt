package com.triforce.malacprodavac.data.local.couriers

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.triforce.malacprodavac.data.local.user.UserEntity

@Entity(foreignKeys = [ForeignKey(
    entity = UserEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("userId")
)])
data class CourierEntity(
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val pricePerKilometer: Double?,
    val currentLocationLatitude: Double?,
    val currentLocationLongitude: Double?,
    val currentLocation: String,
    val createdAt: String,
    val updatedAt: String,
)
