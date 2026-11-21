package com.ketabkhaneman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryScreen()
        }
    }
}

@Composable
fun LibraryScreen() {
    val darkWood = Color(0xFF35251D)
    val gold = Color(0xFFC6A15B)
    val paper = Color(0xFFF2E8D5)
    val green = Color(0xFF315747)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = darkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "کتابخانه من",
                color = gold,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "کتاب‌هایت را همیشه در دسترس داشته باش",
                color = paper,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            LibraryButton("فهرست کتاب‌ها", green)
            LibraryButton("افزودن کتاب", green)
            LibraryButton("ثبت امانت", green)
            LibraryButton("وضعیت امانت‌ها", green)
            LibraryButton("پشتیبان‌گیری", green)
        }
    }
}

@Composable
fun LibraryButton(title: String, color: Color) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .height(52.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(
            text = title,
            fontSize = 17.sp,
            color = Color.White
        )
    }
}
