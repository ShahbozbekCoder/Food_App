@file:OptIn(ExperimentalMaterial3Api::class)

package com.shahbozbek.foodapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xD9EF2A39)) // Color of Background
    ) {
        // Header
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigate("custom_support_screen")
            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // User Information
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .width(650.dp)
                    .align(Alignment.BottomCenter)
                    .padding(top = 80.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Spacer(modifier = Modifier.height(64.dp))
                    ProfileField(label = "Name", value = "Sophia Patel")
                    Spacer(modifier = Modifier.height(16.dp))
                    ProfileField(label = "Email", value = "sophiapatel@gmail.com")
                    Spacer(modifier = Modifier.height(16.dp))
                    ProfileField(
                        label = "Delivery address",
                        value = "123 Main St Apartment 4A, New York, NY"
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ProfileField(label = "Password", value = "**********", isPassword = true)
                    Spacer(modifier = Modifier.height(32.dp))

                    HorizontalDivider(
                        color = Color(0xFFE8E8E8),
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Payment and Order history buttons
                    ButtonOption(label = "Payment Details")
                    Spacer(modifier = Modifier.height(16.dp))
                    ButtonOption(label = "Order history")

                    Spacer(modifier = Modifier.weight(1f))

                    // Edit and Log Out buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            onClick = { /* Edit profile action */ },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF3A3130)
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                                .width(195.dp)
                                .height(60.dp),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Edit Profile", color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit",
                                        tint = Color.White
                                    )
                                }
                            }
                        }

                        Card(
                            onClick = { /* Log out action */ },
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                                .width(195.dp)
                                .height(60.dp),
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(3.dp, Color(0xFFEF2A39))
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Log Out", color = Color(0xFFEF2A39),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                        contentDescription = "Log out",
                                        tint = Color(0xFFEF2A39)
                                    )
                                }
                            }
                        }
                    }
                }
            }
            // Profile header
            Image(
                painter = painterResource(id = R.drawable.person), // Replace with your image
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(3.dp, Color(0xFFEF2A39), RoundedCornerShape(16.dp))
                    .align(Alignment.TopCenter)
                    .shadow(
                        elevation = 4.dp, shape = RoundedCornerShape(16.dp),
                        spotColor = Color(0xFFEF2A39)
                    ),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ProfileField(label: String, value: String, isPassword: Boolean = false) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = { /* Do nothing */ },
            readOnly = true,
            trailingIcon = if (isPassword) {
                { Icon(imageVector = Icons.Default.Lock, contentDescription = "Password") }
            } else null,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFE1E1E1),
                unfocusedBorderColor = Color(0xFFE1E1E1),
                containerColor = Color.Transparent
            ),
            textStyle = TextStyle(
                color = Color(0xFF3C2F2F),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            shape = RoundedCornerShape(16.dp),
            label = {
                Text(
                    text = label,
                    color = Color(0xFF808080),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        )
    }
}

@Composable
fun ButtonOption(label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable {
                // Handle button click
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color(0xFF808080),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color(0xFF808080),
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreen(navController = NavController(LocalContext.current))
}
