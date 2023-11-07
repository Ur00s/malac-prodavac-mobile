package com.triforce.malacprodavac.presentation.higlightDetailed

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.triforce.malacprodavac.LinearGradient
import com.triforce.malacprodavac.Product
import com.triforce.malacprodavac.presentation.home.CategoriesSection
import com.triforce.malacprodavac.presentation.store.HeaderSectionTitle
import com.triforce.malacprodavac.presentation.store.category.CategorySectionHeader
import com.triforce.malacprodavac.presentation.store.category.FilterSortRow
import com.triforce.malacprodavac.presentation.store.category.ShowcaseProducts
import com.triforce.malacprodavac.ui.theme.MP_Black
import com.triforce.malacprodavac.ui.theme.MP_Green
import com.triforce.malacprodavac.ui.theme.MP_Pink
import com.triforce.malacprodavac.ui.theme.MP_Pink_Dark
import com.triforce.malacprodavac.ui.theme.MP_White

@Composable
fun HighlightDetailed(navController: NavController) {
    Box(
        modifier = Modifier
            .background(MP_White)
            .fillMaxSize()
    ) {
        LinearGradient(color1 = MP_Pink, color2 = MP_Pink_Dark)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 65.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
        ) {

        }
        Column {
            HeaderSectionTitle("Više od prodavca", navController)
            BriefDescription(
                title = "Sveži sokovi za Vaš užitak!",
                description = "Domaćinstvo Perun se generacijama bavi domaćom proizvodnjom sokova i sirupa od različitog voća koje se hladno cedi, zatim..."
            )
            FilterSortRow(navController)
            ShowcaseProducts(
                products = listOf(
                    Product(
                        title = "Sok od višnje 0,2l",
                        imageID = Icons.Filled.AccountBox,
                        price = 99.0F,
                        saved = true,
                        desc = ""
                    ),
                    Product(
                        title = "Sok od jagode 0,2l",
                        imageID = Icons.Filled.AccountBox,
                        price = 199.0F,
                        saved = false,
                        desc = ""
                    ),
                    Product(
                        title = "Sirup od jagode 1l",
                        imageID = Icons.Filled.AccountBox,
                        price = 590.0F,
                        saved = false,
                        desc = ""
                    ),
                    Product(
                        title = "Sirup od aronije 1l",
                        imageID = Icons.Filled.AccountBox,
                        price = 520.0F,
                        saved = true,
                        desc = ""
                    ),
                    Product(
                        title = "Sok od ribizle",
                        imageID = Icons.Filled.AccountBox,
                        price = 890.0F,
                        saved = false,
                        desc = ""
                    ),
                    Product(
                        title = "Sirup od drena",
                        imageID = Icons.Filled.AccountBox,
                        price = 199.0F,
                        saved = false,
                        desc = ""
                    ),
                ), navController
            )
        }
    }
}

@Composable
fun BriefDescription(
    title: String,
    description: String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth(1F)
            .height(
                height = 200.dp
            )
            .padding(
                horizontal = 30.dp
            )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5,
            color = MP_Black,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Center
        )
        Text(
            text = description,
            style = androidx.compose.material.MaterialTheme.typography.body1,
            color = Color.Gray,
            fontWeight = FontWeight.W300,
            textAlign = TextAlign.Center
        )
    }
}