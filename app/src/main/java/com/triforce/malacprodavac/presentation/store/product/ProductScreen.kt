package com.triforce.malacprodavac.presentation.store.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.triforce.malacprodavac.LinearGradient
import com.triforce.malacprodavac.Product
import com.triforce.malacprodavac.Screen
import com.triforce.malacprodavac.presentation.home.CategoriesSection
import com.triforce.malacprodavac.presentation.store.HeaderSectionTitle
import com.triforce.malacprodavac.presentation.store.category.CategorySectionHeader
import com.triforce.malacprodavac.presentation.store.category.FilterSortRow
import com.triforce.malacprodavac.presentation.store.category.ShowcaseProducts
import com.triforce.malacprodavac.presentation.store.category.StoreCategoryProduct
import com.triforce.malacprodavac.ui.theme.MP_Black
import com.triforce.malacprodavac.ui.theme.MP_Gray
import com.triforce.malacprodavac.ui.theme.MP_Green
import com.triforce.malacprodavac.ui.theme.MP_GreenDark
import com.triforce.malacprodavac.ui.theme.MP_Pink
import com.triforce.malacprodavac.ui.theme.MP_Pink_Dark
import com.triforce.malacprodavac.ui.theme.MP_White

@Composable
fun ProductScreen(navController: NavController)
{
    Box(
        modifier = Modifier
            .background(MP_White)
            .fillMaxSize()
    ){
        LinearGradient(color1 = MP_Green, color2 = MP_GreenDark )
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
            HeaderSectionTitle("Sok od višnje", navController)
            HeroImage()
            ProductDetails(
                product = Product(
                    title = "Sok od višnje 0,2l",
                    imageID = Icons.Filled.AccountBox,
                    price = 590.0F,
                    saved = true,
                    desc = "Domaći sirup od višnje, iako zaslađen šećerom, pruža osvežavajući i okrepljujući ukus. " +
                            "Razblažuje se sa vodom u razmeri prema ukusu. Ne sadrži veštačke boje, arome i konzervanse. " +
                            "\n\nPre upotrebe promućkati i sipati."
                )
            )
            ShowHighlightSection(
                navController = navController,
                product1 = Product(
                    title = "Sok od višnje 0,2l",
                    imageID = Icons.Filled.AccountBox,
                    price = 520.0F,
                    saved = false,
                    desc = "Domaći sirup od višnje, iako zaslađen šećerom, pruža osvežavajući i okrepljujući ukus. " +
                            "Razblažuje se sa vodom u razmeri prema ukusu. Ne sadrži veštačke boje, arome i konzervanse. " +
                            "\n\nPre upotrebe promućkati i sipati."
                ),
                product2 = Product(
                    title = "Sok od višnje 0,2l",
                    imageID = Icons.Filled.AccountBox,
                    price = 99.0F,
                    saved = true,
                    desc = "Domaći sirup od višnje, iako zaslađen šećerom, pruža osvežavajući i okrepljujući ukus. " +
                            "Razblažuje se sa vodom u razmeri prema ukusu. Ne sadrži veštačke boje, arome i konzervanse. " +
                            "\n\nPre upotrebe promućkati i sipati."
                ),
                title = "Više proizvoda od prodavca"
            )
            ShowFavouriteAddToCart(
                navController = navController
            )
        }
    }
}

@Composable
fun HeroImage(

) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .background(MP_White, RoundedCornerShape(10.dp))
            .padding(35.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Malac Prodavac",
            tint = MP_Gray,
            modifier = Modifier
                .size(100.dp)
        )
    }
}

@Composable
fun ProductDetails(
    product: Product
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 50.dp,
                bottom = 10.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 20.dp
                )
        ){
            Text(
                text = product.title,
                style = MaterialTheme.typography.h5,
                color = MP_Black,
                fontWeight = FontWeight.W500
            )
            Text(
                text = product.price.toString() + " rsd",
                style = androidx.compose.material.MaterialTheme.typography.h5,
                color = MP_Green,
                fontWeight = FontWeight.W500
            )
        }
        Text(
            text = product.desc,
            style = androidx.compose.material.MaterialTheme.typography.body1,
            color = Color.Gray,
            softWrap = true
        )
    }
}

@Composable
fun ShowHighlightSection(
    navController: NavController,
    product1: Product,
    product2: Product,
    title: String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 15.dp,
                    bottom = 15.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                color = MP_Black,
                fontWeight = FontWeight.W500
            )
            androidx.compose.material3.Text(
                text = "Vidi više",
                style = MaterialTheme.typography.caption,
                color = MP_White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.HighlightDetailed.route)
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(MP_Pink)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
        ShowcaseProducts(
            products = listOf(product1,product2),
            navController = navController
        )
    }
}

@Composable
fun ShowFavouriteAddToCart(
    navController: NavController
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 15.dp,
                bottom = 15.dp,
                start = 20.dp,
                end = 20.dp
            )
    ){
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = "FavoriteBorder",
            tint = MP_Pink,
            modifier = Modifier
                .size(50.dp)
        )
        Text(
            text = "Dodaj u korpu",
            style = MaterialTheme.typography.h5,
            color = MP_White,
            fontWeight = FontWeight.W500,
            modifier = Modifier
                .clickable {
                }
                .clip(RoundedCornerShape(10.dp))
                .background(MP_Pink)
                .padding(vertical = 6.dp, horizontal = 15.dp)
        )
    }
}