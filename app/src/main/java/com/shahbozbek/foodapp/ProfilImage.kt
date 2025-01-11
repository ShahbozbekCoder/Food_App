package com.shahbozbek.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileImageWithCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xD9EF2A39))
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* Back action */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* Settings action */ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        // User Information
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            // Card
            Card(
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter) // Kartani pastroqqa joylashtirish
                    .padding(top = 64.dp) // Tasvir uchun joy qoldirish
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    ProfileField(label = "Name", value = "Sophia Patel")
                    Spacer(modifier = Modifier.height(8.dp))
                    ProfileField(label = "Email", value = "sophiapatel@gmail.com")
                    Spacer(modifier = Modifier.height(8.dp))
                    ProfileField(
                        label = "Delivery address",
                        value = "123 Main St Apartment 4A, New York, NY"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ProfileField(label = "Password", value = "**********", isPassword = true)
                    Spacer(modifier = Modifier.height(16.dp))

                    // Payment and Order history buttons
                    ButtonOption(label = "Payment Details")
                    Spacer(modifier = Modifier.height(8.dp))
                    ButtonOption(label = "Order history")

                    Spacer(modifier = Modifier.weight(1f))

                    // Edit and Log Out buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { /* Edit profile action */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3130)),
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Edit Profile", color = Color.White)
                        }

                        Button(
                            onClick = { /* Log out action */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                contentDescription = "Log out",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Log Out", color = Color.White)
                        }
                    }
                }
            }

            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.person), // Replace with your image
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp, Color.Red, RoundedCornerShape(8.dp))
                    .align(Alignment.TopCenter)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileImageWithCardPreview() {
    ProfileImageWithCard()
}

