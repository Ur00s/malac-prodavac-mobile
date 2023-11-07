package com.triforce.malacprodavac.presentation.store.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.triforce.malacprodavac.Feature
import com.triforce.malacprodavac.LinearGradient
import com.triforce.malacprodavac.Product
import com.triforce.malacprodavac.Screen
import com.triforce.malacprodavac.presentation.home.CategoriesSection
import com.triforce.malacprodavac.presentation.home.RecommendedFeaturesSection
import com.triforce.malacprodavac.presentation.store.HeaderSectionTitle
import com.triforce.malacprodavac.presentation.store.StoreCategorieItem
import com.triforce.malacprodavac.ui.theme.MP_Black
import com.triforce.malacprodavac.ui.theme.MP_Gray
import com.triforce.malacprodavac.ui.theme.MP_Green
import com.triforce.malacprodavac.ui.theme.MP_GreenLight
import com.triforce.malacprodavac.ui.theme.MP_Orange
import com.triforce.malacprodavac.ui.theme.MP_Orange_Dark
import com.triforce.malacprodavac.ui.theme.MP_Pink
import com.triforce.malacprodavac.ui.theme.MP_Pink_Dark
import com.triforce.malacprodavac.ui.theme.MP_White

@Composable
fun StoreCategoryScreen(navController: NavController)
{
    Box(
        modifier = Modifier
            .background(MP_White)
            .fillMaxSize()
    ){
        LinearGradient(color1 = MP_Pink, color2 = MP_Pink_Dark )
        Surface (
            color = MP_White,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F)
                .padding(top = 250.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
        ){

        }
        Column {
            HeaderSectionTitle("Sirupi i sokovi", navController)
            CategorySectionHeader("100% domaći i prirodni sokovi",
                "Voće se prvo hladno cedi, zatim pasterizuje i bez ikakvih dodataka pakuje u staklenu ambalažu.")
            CategoriesSection(categories = listOf("Bez Aditiva", "Sirupi", "Sokovi"))
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
fun CategorySectionHeader(
    title: String,
    sub: String,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .background(MP_Pink, RoundedCornerShape(10.dp))
            .padding(15.dp)
    ) {
        Column (
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MP_White,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(0.5F)
            )
            Text(
                text = sub,
                style = MaterialTheme.typography.bodyMedium,
                color = MP_White,
                modifier = Modifier
                    .fillMaxWidth(0.6F)
            )
        }
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Malac Prodavac",
            tint = MP_White,
            modifier = Modifier
                .size(100.dp)
        )
    }
}

@Composable
fun FilterSortRow(
    navController: NavController
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 7.5.dp
            )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .size(
                    width =  75.dp,
                    height = 20.dp
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Filtriraj",
                tint = MP_Green,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                    }
            )
            Text(
                text = "Filtriraj",
                style = androidx.compose.material.MaterialTheme.typography.body2,
                color = MP_Black,
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .size(
                    width =  75.dp,
                    height = 20.dp
                )

        ) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Sortiraj",
                tint = MP_Orange,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                    }
            )
            Text(
                text = "Sortiraj",
                style = androidx.compose.material.MaterialTheme.typography.body2,
                color = MP_Black,
            )
        }
    }
}

@Composable
fun ShowcaseProducts(
    products: List<Product>,
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            top = 7.5.dp,
            start = 7.5.dp,
            end = 7.5.dp,
            bottom = 80.dp
        ), // 100 dp bottom padding because navigation
        modifier = Modifier.fillMaxHeight(),
    ) {
        items(products.size) {// how many items do we have
            // define one of items
            StoreCategoryProduct(product = products[it], navController)
        }
    }
}

@Composable
fun StoreCategoryProduct (
    product: Product,
    navController: NavController
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(start = 7.5.dp, end = 7.5.dp, bottom = 15.dp)
            .shadow(
                elevation = 5.dp,
                spotColor = MP_Black,
                shape = RoundedCornerShape(7.5.dp)
            )
            .padding(1.5.dp)
            .aspectRatio(0.8F) // ratio is 1x1 so whatever the width is, the hegiht will be the same
            .clip(RoundedCornerShape(10.dp))
            .background(MP_White)
            .clickable {
                navController.navigate(Screen.ProductScreen.route)
            }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Box(
                    modifier = Modifier
                        .size(
                            width = 150.dp,
                            height = 125.dp
                        )
                        .background(MP_Gray)
                        .align(Alignment.CenterHorizontally)
                ){
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = product.imageID.toString(),
                        tint = MP_White,
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center)
                    )
                }
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .padding(
                            top = 7.5.dp
                        )
                ) {
                    Text(
                        text = product.title,
                        style = androidx.compose.material.MaterialTheme.typography.body2,
                        color = MP_Black
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 5.dp
                            )
                    ) {
                        Text(
                            text = product.price.toString() + " rsd",
                            style = androidx.compose.material.MaterialTheme.typography.body2,
                            color = MP_Green,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            imageVector = if (product.saved) {
                                Icons.Filled.Favorite
                            } else {
                                Icons.Filled.FavoriteBorder
                            },
                            contentDescription = product.imageID.toString(),
                            tint = MP_Pink,
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                }
                        )
                    }
                }
            }
        }
    }
}