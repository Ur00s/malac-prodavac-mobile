package com.triforce.malacprodavac.data.mappers

import com.triforce.malacprodavac.data.local.user.UserEntity
import com.triforce.malacprodavac.domain.model.User

fun UserEntity.toUser(): User = User(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    address = address,
    phoneNumber = phoneNumber ?: "",
    addressLatitude = addressLatitude,
    addressLongitude = addressLongitude,
    paymentMethod = paymentMethod,
    roles = roles,
    currency = currency,
    createdAt = createdAt,
    updatedAt = updatedAt,

    customer = null,
    courier = null,
    shop = null
)

