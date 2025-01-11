package com.shahbozbek.foodapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterItem(types: List<String>, index: Int, onClick: () -> Unit) {
    val isClicked = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = Color(0xFFF3F4F6),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                onClick()
                isClicked.value = !isClicked.value
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = types[index],
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = if (isClicked.value) Color(0xFFEF2A39) else Color(0xFF6A6A6A)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FilterItemPreview() {
    FilterItem(types = listOf("All", "Pizza", "Burgers"), index = 0, onClick = {})
}