package com.triforce.malacprodavac.presentation.cart.CartDetails

import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.triforce.malacprodavac.BottomNavigationMenuContent
import com.triforce.malacprodavac.LinearGradient
import com.triforce.malacprodavac.Screen
import com.triforce.malacprodavac.presentation.cart.BuyedProduct
import com.triforce.malacprodavac.presentation.cart.TotalPrice
import com.triforce.malacprodavac.presentation.home.BottomNavigationMenu
import com.triforce.malacprodavac.ui.theme.MP_Black
import com.triforce.malacprodavac.ui.theme.MP_Orange
import com.triforce.malacprodavac.ui.theme.MP_Orange_Dark
import com.triforce.malacprodavac.ui.theme.MP_Pink
import com.triforce.malacprodavac.ui.theme.MP_White
import org.w3c.dom.Text

@Composable
fun CartDetailsScreen(navController: NavController) {

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

    val typeOfPaymentOptions = listOf("Paypal", "Lično/Pouzećem")
    var selectedTypeOfPayment by remember { mutableStateOf(typeOfPaymentOptions[0]) }

    val addressesOptions = listOf(
//        "Živorada Kostića, Jagodina 35000, 066/251-101"
        "Gavrila Principa, Kragujevac, 066/251-102"
    )
    var selectedAddress by remember { mutableStateOf(addressesOptions[0]) }

    val typeOfSendingOptions = listOf("Lično preuzimanje", "Kurirska dostava")
    var selectedTypeOfSending by remember { mutableStateOf(typeOfSendingOptions[0]) }

    Box(
        modifier = Modifier
            .background(MP_White)
            .fillMaxSize()
    ) {
        LinearGradient(color1 = MP_Orange, color2 = MP_Orange_Dark)
        Surface(
            color = MP_White,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F)
                .padding(top = 67.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
        ) {

        }
        Column {
            HeaderSectionTitleWithoutIcon("Detalji plaćanja", navController)

            Text(
                text = "Način plaćanja",
                style = MaterialTheme.typography.h5,
                color = MP_Black,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 5.dp,
                            spotColor = MP_Black,
                            shape = RoundedCornerShape(7.5.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                ){
                    Column(
                        modifier = Modifier.padding(2.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        typeOfPaymentOptions.forEach { payment ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                RadioButton(
                                    selected = (payment == selectedTypeOfPayment),
                                    onClick = { selectedTypeOfPayment = payment }
                                )
                                Text(
                                    text = payment,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "Podaci za slanje",
                    style = MaterialTheme.typography.h5,
                    color = MP_Black,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Izmeni",
                    style = MaterialTheme.typography.h6,
                    color = MP_White,
                    modifier = Modifier
                        .padding(start = 80.dp, top = 5.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MP_Pink)
                        .padding(7.5.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 5.dp,
                            spotColor = MP_Black,
                            shape = RoundedCornerShape(7.5.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                ){
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        verticalArrangement = Arrangement.spacedBy(13.dp),
                    ) {
                        addressesOptions.forEach { address ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                RadioButton(
                                    selected = (address == selectedAddress),
                                    onClick = { selectedAddress = address }
                                )
                                Text(
                                    text = address,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
            Text(
                text = "Način slanja",
                style = MaterialTheme.typography.h5,
                color = MP_Black,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ){
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 5.dp,
                            spotColor = MP_Black,
                            shape = RoundedCornerShape(7.5.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .padding(vertical = 20.dp, horizontal = 20.dp)
                ){
                    Column(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        typeOfSendingOptions.forEach { typeOfSending ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                RadioButton(
                                    selected = (typeOfSending == selectedTypeOfSending),
                                    onClick = { selectedTypeOfSending = typeOfSending }
                                )
                                Text(
                                    text = typeOfSending,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
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
                        navController.navigate(Screen.DetailsOrderScreen.route)
                    },
                    modifier = Modifier
                ) {
                    Text(
                        text = "Izvrši porudžbinu",
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
fun HeaderSectionTitleWithoutIcon(
    msg: String,
    navController: NavController,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .size(width = 240.dp, height = 35.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Search",
                tint = MP_White,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack()
                        //navController.navigate(Screen.HomeScreen.route)
                    }
            )

            androidx.compose.material3.Text(
                text = msg,
                style = MaterialTheme.typography.h5,
                color = MP_White,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
    }
}
