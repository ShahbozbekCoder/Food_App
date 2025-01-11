package com.shahbozbek.foodapp

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PaymentScreen(navController: NavController) {
    val isCheckboxChecked = remember { mutableStateOf(true) }
    val isSelected = remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF3C2F2F)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* Search action */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color(0xFF3C2F2F)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Order summary
        Text(
            text = "Order summary",
            color = Color(0xFF3C2F2F),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp

        )
        Spacer(modifier = Modifier.height(12.dp))
        SummaryItem(label = "Order", value = "$16.48")
        Spacer(modifier = Modifier.height(12.dp))
        SummaryItem(label = "Taxes", value = "$0.3")
        Spacer(modifier = Modifier.height(12.dp))
        SummaryItem(label = "Delivery fees", value = "$1.5")
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            thickness = 1.dp,
            color = Color(0xFFF0F0F0)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(
                text = "Total:",
                color = Color(0xFF3C2F2F),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            )
            Text(
                text = "$18.19",
                color = Color(0xFF3C2F2F),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = "Estimated delivery time:",
                color = Color(0xFF3C2F2F),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f)
            )
            Text(
                text = "15 - 30 mins",
                color = Color(0xFF3C2F2F),
                modifier = Modifier.padding(horizontal = 16.dp),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        // Payment methods
        Text(
            text = "Payment methods",
            color = Color(0xFF3C2F2F),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        PaymentMethodCard(
            imageResId = R.drawable.mastercard, // Replace with your resource
            cardType = "Credit card",
            cardNumber = "5105 **** **** 0505",
            isSelected = isSelected.value
        )

        Spacer(modifier = Modifier.height(16.dp))

        PaymentMethodCard(
            imageResId = R.drawable.visa, // Replace with your resource
            cardType = "Debit card",
            cardNumber = "3566 **** **** 0505",
            isSelected = !isSelected.value
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                isCheckboxChecked.value = !isCheckboxChecked.value
            }
        ) {
            Checkbox(
                checked = isCheckboxChecked.value,
                onCheckedChange = {
                    isCheckboxChecked.value = it
                },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color.White,
                    disabledCheckedColor = Color(0xFFEF2A39),
                    checkedColor = Color(0xFFEF2A39)
                )
            )
            Text(
                text = "Save card details for future payments",
                color = Color(0xFF808080),
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Footer
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Total price",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text = "$",
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "18.19",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
            Card(
                onClick = {
                    navController.navigate("success_screen")
                },
                modifier = Modifier
                    .width(210.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF3A3130))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Pay Now", color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun SummaryItem(label: String, value: String, isBold: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = Color(0xFF7D7D7D),
            fontSize = 16.sp
        )
        Text(
            text = value,
            color = Color(0xFF7D7D7D),
            fontSize = 16.sp,
        )
    }
}

@Composable
fun PaymentMethodCard(
    imageResId: Int,
    cardType: String,
    cardNumber: String,
    isSelected: Boolean
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF3A3130) else Color.LightGray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .shadow(if (isSelected) 8.dp else 4.dp, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(imageResId),
                contentDescription = "Card Logo",
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = cardType,
                    color = if (isSelected) Color.White else Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = cardNumber,
                    color = if (isSelected) Color.White else Color.Black
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = isSelected,
                onClick = {
                    // Handle radio button selection
                },
                colors = RadioButtonDefaults.colors(selectedColor = Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    PaymentScreen(navController = NavController(LocalContext.current))
}
