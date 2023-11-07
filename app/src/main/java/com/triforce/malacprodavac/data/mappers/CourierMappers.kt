package com.triforce.malacprodavac.data.mappers

import com.triforce.malacprodavac.data.local.couriers.CourierEntity
import com.triforce.malacprodavac.domain.model.Courier

fun CourierEntity.toCourier(): Courier = Courier(
    id = id,
    userId = userId,
    pricePerKilometer = pricePerKilometer,
    currentLocationLatitude = currentLocationLatitude,
    currentLocationLongitude = currentLocationLongitude,
    currentLocation = currentLocation,
    createdAt = createdAt,
    updatedAt = updatedAt,

    user = null
)

