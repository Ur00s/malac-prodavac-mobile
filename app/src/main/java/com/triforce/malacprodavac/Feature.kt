package com.triforce.malacprodavac

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Feature(
    val title: String,
    val graphicID: ImageVector,
    val color1: Color,
    val color2: Color,
    val screen: Screen
)
