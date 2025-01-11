package com.shahbozbek.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                cutoutShape = RoundedCornerShape(50),
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = true,
                            onClick = {},
                            icon = {
                                Icon(
                                    Icons.Default.Home,
                                    contentDescription = "Home",
                                    tint = Color.White
                                )
                            },
                            label = { Text("Home") },
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            selected = true,
                            onClick = {},
                            icon = {
                                Icon(
                                    Icons.Default.Person,
                                    contentDescription = "Person",
                                    tint = Color.White
                                )
                            },
                            label = { Text("Person") },
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            selected = true,
                            onClick = {},
                            icon = {
                                Icon(
                                    painter = painterResource(R.drawable.comment),
                                    contentDescription = "Comment",
                                    tint = Color.White
                                )
                            },
                            label = { Text("Comment") },
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            selected = true,
                            onClick = {},
                            icon = {
                                Icon(
                                    Icons.Default.Favorite,
                                    contentDescription = "Favorite",
                                    tint = Color.White
                                )
                            },
                            label = { Text("Favorite") },
                            alwaysShowLabel = false
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("order_screen")
                },
                containerColor = Color(0xFFEF2A39),
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(64.dp)
                    .shadow(elevation = 6.dp, shape = CircleShape)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        content = { paddingValue ->
            MainScreen(paddingValue, navController)
        }
    )

}

@Composable
fun MainScreen(paddingValue: PaddingValues, navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Foodgo",
                    color = Color.Black,
                    fontSize = 50.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Order your favorite food!",
                    color = Color(0xFF6A6A6A),
                    fontSize = 20.sp,
                )
            }
            Image(
                painter = painterResource(R.drawable.person),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .align(Alignment.Top)
                    .size(60.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate("profile_screen")
                    },
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                placeholder = { Text("Search") },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black
                    )
                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .width(300.dp)
                    .padding(horizontal = 4.dp)
                    .shadow(elevation = 6.dp, shape = RoundedCornerShape(16.dp))
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                modifier = Modifier
                    .size(57.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEF2A39)
                ), content = {
                    IconButton(
                        onClick = {
                            navController.navigate("product_details_screen")
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "List",
                            tint = Color.White
                        )
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        SelectableLazyRow()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(10) {
                    ProductItem()
                }
            }
        )
    }
}

@Composable
fun SelectableLazyRow() {
    // Tanlangan elementning indeksini saqlash
    var selectedIndex by remember { mutableIntStateOf(0) }

    // Ro'yxatdagi elementlar
    val items = listOf("All", "Combos", "Slider", "Pizzas", "Burgers")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Elementlar orasidagi masofa
    ) {
        itemsIndexed(items) { index, item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(if (selectedIndex == index) 4.dp else 0.dp, RoundedCornerShape(16.dp))
                    .clickable { selectedIndex = index }, // Bosilganda indeksni yangilash
                elevation = if (selectedIndex == index) CardDefaults.cardElevation(4.dp) else CardDefaults.cardElevation(
                    0.dp
                ), // Soya effekti
                shape = RoundedCornerShape(16.dp), // Burchaklarni yumaloqlash
                colors = CardDefaults.cardColors(
                    containerColor = if (selectedIndex == index) Color(0xFFEF2A39) else Color(
                        0xFFF3F4F6
                    )
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp, 50.dp) // Card o'lchami
                ) {
                    Text(
                        text = item,
                        color = if (selectedIndex == index) Color.White else Color.Black, // Matn rangi
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}