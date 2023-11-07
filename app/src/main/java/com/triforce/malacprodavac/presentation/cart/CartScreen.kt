package com.triforce.malacprodavac.presentation.cart

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
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.triforce.malacprodavac.BottomNavigationMenuContent
import com.triforce.malacprodavac.LinearGradient
import com.triforce.malacprodavac.R
import com.triforce.malacprodavac.Screen
import com.triforce.malacprodavac.presentation.home.BottomNavigationMenu
import com.triforce.malacprodavac.presentation.store.HeaderSectionTitle
import com.triforce.malacprodavac.ui.theme.MP_Black
import com.triforce.malacprodavac.ui.theme.MP_Gray
import com.triforce.malacprodavac.ui.theme.MP_Green
import com.triforce.malacprodavac.ui.theme.MP_Orange
import com.triforce.malacprodavac.ui.theme.MP_Orange_Dark
import com.triforce.malacprodavac.ui.theme.MP_Pink
import com.triforce.malacprodavac.ui.theme.MP_White

@Composable
fun CartScreen(navController: NavController)
{

    val buyedProducts = listOf(
        BuyedProduct(
            name = "Pršuta 100g",
            price = 590.00
        ),
        BuyedProduct(
            name = "Kajmak 100g",
            price = 670.00
        ),
        BuyedProduct(
            name = "Jabuke 1kg",
            price = 75.00
        ),
        BuyedProduct(
            name = "Domaće mleko 2l",
            price = 210.99
        )

    )

    Box(
        modifier = Modifier
            .background(MP_White)
            .fillMaxSize()
    ){
        LinearGradient(color1 = MP_Orange, color2 = MP_Orange_Dark )
        Surface (
            color = MP_White,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F)
                .padding(top = 67.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
        ){

        }
        Column {
            HeaderSectionTitle("Moja korpa", navController)
            BuyedProductSection(
                buyedProducts = buyedProducts
            )
        }
        TotalPrice(buyedProducts = buyedProducts)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(25.dp))
                .padding(
                    start = 5.dp,
                    top = 663.dp,
                    end = 5.dp,
                    bottom = 40.dp
                )
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screen.CartDetailsScreen.route)
                    }
                ) {
                    Text(
                        text = "Nastavi sa plaćanjem",
                        color = MP_White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        BottomNavigationMenu(navController = navController,
            items = listOf(
                BottomNavigationMenuContent(
                    title = "Početna",
                    graphicID = Icons.Default.Home,
                    screen = Screen.HomeScreen,
                    isActive = true
                ),
                BottomNavigationMenuContent(
                    title = "Prodavnica",
                    graphicID = Icons.Default.AddCircle,
                    screen = Screen.HomeScreen,
                    isActive = false
                ),
                BottomNavigationMenuContent(
                    title = "Moj Profil",
                    graphicID = Icons.Default.AccountCircle,
                    screen = Screen.HomeScreen,
                    isActive = false
                ),
                BottomNavigationMenuContent(
                    title = "Korpa",
                    graphicID = Icons.Default.ShoppingCart,
                    screen = Screen.CartScreen,
                    isActive = false
                )
            ), modifier = Modifier.
            align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BuyedProductSection(
    buyedProducts: List<BuyedProduct>
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(
                start = 20.5.dp,
                end = 7.5.dp,
                bottom = 130.dp
            ), // 130 dp bottom padding because navigation and total price
            modifier = Modifier
                .requiredHeight(500.dp)
        ) {
            items(buyedProducts.size) {// how many items do we have
                // define one of items
                BuyedProductItem(
                    buyedProduct = buyedProducts[it]
                )
            }
        }
    }
}

@Composable
fun BuyedProductItem(
    buyedProduct: BuyedProduct
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(5.dp)
            .shadow(
                elevation = 5.dp,
                spotColor = MP_Black,
                shape = RoundedCornerShape(7.5.dp)
            )
            .aspectRatio(1.8F)
            .clip(RoundedCornerShape(10.dp))
            .requiredHeight(195.dp)
            .background(MP_Gray)
    ) {

        Box(
            modifier = Modifier
                .requiredWidth(400.dp)
                .padding(30.dp)
        ) {

            Text(
                text = buyedProduct.name,
                fontWeight = FontWeight.Bold,
                style = androidx.compose.material.MaterialTheme.typography.h5,
                lineHeight = 15.sp,
                color = MP_Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
            )

            Text(
                text = buyedProduct.price.toString() + "rsd",
                style = androidx.compose.material.MaterialTheme.typography.h6,
                lineHeight = 15.sp,
                color = MP_Green,
                modifier = Modifier
                    .align(Alignment.CenterStart)
            )
            Text(
                text = buyedProduct.amount.toString() + "X",
                style = androidx.compose.material.MaterialTheme.typography.h6,
                lineHeight = 15.sp,
                color = MP_Black,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )

            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .align(Alignment.BottomEnd)
                    .requiredWidth(100.dp)
                    .requiredHeight(90.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add",
                    tint = MP_Green,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.BottomStart)
                        .clickable {
                            buyedProduct.amount = buyedProduct.amount + 1
                        }
                )

                Icon(
                    painter = painterResource(id = R.drawable.round_remove_circle_24),
                    contentDescription = "Remove one",
                    tint = MP_Pink,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.BottomCenter)
                        .clickable {
                            if (buyedProduct.amount > 1)
                                buyedProduct.amount = buyedProduct.amount - 1
                        }
                )

                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete one",
                    tint = MP_Orange_Dark,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.BottomEnd)
                        .clickable {

                        }
                )
            }
        }
    }
}

@Composable
fun TotalPrice(buyedProducts: List<BuyedProduct>) {

    var totalPrice: Double = 0.00
    for (buyedProduct in buyedProducts) {
        totalPrice += buyedProduct.total
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .padding(
                start = 5.dp,
                top = 590.dp,
                end = 5.dp,
                bottom = 40.dp
            )
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 20.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(MP_Green)
                    .padding(10.dp)
            )
            {
                Text(
                    text = "Ukupan iznos:",
                    fontWeight = FontWeight.Bold,
                    style = androidx.compose.material.MaterialTheme.typography.h5,
                    lineHeight = 17.sp,
                    color = MP_White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                )

                Text(
                    text = totalPrice.toString() + "RSD",
                    style = androidx.compose.material.MaterialTheme.typography.h5,
                    lineHeight = 17.sp,
                    color = MP_White,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }
}
