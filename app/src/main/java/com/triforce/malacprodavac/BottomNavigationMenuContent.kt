package com.triforce.malacprodavac

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationMenuContent(
    val title: String,
    val graphicID: ImageVector,
    val screen: Screen,
    var isActive: Boolean
)
