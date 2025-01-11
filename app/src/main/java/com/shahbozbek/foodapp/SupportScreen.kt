@file:OptIn(ExperimentalMaterial3Api::class)

package com.shahbozbek.foodapp

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CustomerSupportUI(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Dark background
            .padding(16.dp)
    ) {
        // Header
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Customer support",
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = { /* Handle options click */ }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Options",
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Chat Messages
        LazyColumn(
            modifier = Modifier.weight(1f),
            reverseLayout = false // Messages go from top to bottom
        ) {
            items(chatMessages.size) { message ->
                ChatMessageItem(message = chatMessages[message])
                Spacer(modifier = Modifier.height(32.dp))
            }
        }

        // Input Box

        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            RoundedTextField(
                value = text,
                onValueChange = { text = it },
                onSendClick = {
                    // Handle send action
                    text = ""
                }
            )
        }
    }
}

@Composable
fun ChatMessageItem(message: ChatMessage) {
    val isUser = message.isUser

    Row(
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (!isUser) {
            Icon(
                painter = painterResource(id = R.drawable.person_24),
                contentDescription = "Agent",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF3C2F2F))
                    .padding(4.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Box(
            modifier = Modifier
                .background(
                    if (isUser) Color(0xFFEF2A39) else Color(0xFFF3F4F6),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
        ) {
            Text(
                text = message.text,
                color = if (isUser) Color.White else Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        if (isUser) {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "User",
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .border(1.dp, Color(0xFFEF2A39), CircleShape),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

// Sample Data
data class ChatMessage(val text: String, val isUser: Boolean)

val chatMessages = listOf(
    ChatMessage("Hi, how can I help you?", isUser = false),
    ChatMessage(
        "Hello, I ordered two fried chicken burgers. Can I know how much time it will get to arrive?",
        isUser = true
    ),
    ChatMessage("Ok, please let me check!", isUser = false),
    ChatMessage("Sure...", isUser = true),
    ChatMessage("It’ll get 25 minutes to arrive to your address", isUser = false),
    ChatMessage("Ok, thanks for your support", isUser = true)
)

@Preview(showBackground = true)
@Composable
fun CustomerSupportUIPreview() {
    CustomerSupportUI(navController = NavController(LocalContext.current))
}
