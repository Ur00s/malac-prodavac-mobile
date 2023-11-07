package com.triforce.malacprodavac.presentation.cart

data class BuyedProduct(
    val name: String = "",
    val price: Double = 0.0,
    var amount: Int = 1,
    var total: Double = price * amount
)
