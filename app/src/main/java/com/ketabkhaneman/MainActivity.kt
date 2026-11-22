
package com.ketabkhaneman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Wood = Color(0xFF35251D)
private val WoodLight = Color(0xFF513A2C)
private val Gold = Color(0xFFC6A15B)
private val Paper = Color(0xFFF2E8D5)
private val Green = Color(0xFF315747)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryApp()
        }
    }
}

@Composable
fun LibraryApp() {
    var page by remember { mutableStateOf("خانه") }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Wood
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "کتابخانه من",
                        color = Gold,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "کتاب‌ها و دانایی",
                        color = Paper,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))

                when (page) {
                    "خانه" -> HomePage { page = it }
                    "فهرست کتاب‌ها" -> SimplePage(
                        "فهرست کتاب‌ها",
                        "کتاب‌های ثبت‌شده در این بخش نمایش داده می‌شوند."
                    )
                    "افزودن کتاب" -> SimplePage(
                        "افزودن کتاب",
                        "فرم ثبت عنوان، نویسنده، ناشر و نسخه‌ها در مرحله بعد ساخته می‌شود."
                    )
                    "ثبت امانت" -> SimplePage(
                        "ثبت امانت",
                        "امانت دادن نسخه‌های کتاب در این بخش انجام می‌شود."
                    )
                    "وضعیت امانت‌ها" -> SimplePage(
                        "وضعیت امانت‌ها",
                        "امانت‌های فعال و سوابق بازگشت در این بخش قرار می‌گیرند."
                    )
                    "پشتیبان‌گیری" -> SimplePage(
                        "پشتیبان‌گیری",
                        "ابزار پشتیبان‌گیری و بازیابی در این بخش قرار می‌گیرد."
                    )
                    else -> HomePage { page = it }
                }

                Spacer(modifier = Modifier.weight(1f))

                if (page != "خانه") {
                    Button(
                        onClick = { page = "خانه" },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Green
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("بازگشت به خانه", color = Paper)
                    }
                }
            }
        }
    }
}

@Composable
fun HomePage(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    WoodLight,
                    RoundedCornerShape(16.dp)
                )
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("📚", fontSize = 48.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "به کتابخانه خود خوش آمدید",
                    color = Gold,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "سامان‌دهی مجموعه شخصی کتاب‌ها",
                    color = Paper,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        MenuButton("فهرست کتاب‌ها", "📖", onNavigate)
        MenuButton("افزودن کتاب", "➕", onNavigate)
        MenuButton("ثبت امانت", "📤", onNavigate)
        MenuButton("وضعیت امانت‌ها", "📋", onNavigate)
        MenuButton("پشتیبان‌گیری", "💾", onNavigate)
    }
}

@Composable
fun MenuButton(
    title: String,
    icon: String,
    onNavigate: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .background(Green, RoundedCornerShape(12.dp))
            .clickable { onNavigate(title) }
            .padding(horizontal = 18.dp, vertical = 17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(icon, fontSize = 22.sp)
        Spacer(modifier = Modifier.width(14.dp))
        Text(
            title,
            color = Paper,
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun SimplePage(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(WoodLight, RoundedCornerShape(16.dp))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            title,
            color = Gold,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            description,
            color = Paper,
            fontSize = 16.sp
        )
    }
}
