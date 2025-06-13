package com.tripleu.dummychromebrowser.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// A single, clean color scheme for the application.
private val LightColors = lightColorScheme(
    primary = Color(0xFFD32F2F), // A clear "warning" or "blocked" color
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    onSurfaceVariant = Color(0xFF49454F) // A readable gray for secondary text
)

@Composable
fun DummyChromeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography, // Using the existing Typography.kt
        content = content
    )
}
