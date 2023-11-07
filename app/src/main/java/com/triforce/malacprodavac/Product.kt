package com.triforce.malacprodavac

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Product(
    val title: String,
    val imageID: ImageVector,
    val price: Float,
    val saved: Boolean,
    val desc: String
)
