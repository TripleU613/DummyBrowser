package com.tripleu.dummychromebrowser

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tripleu.dummychromebrowser.ui.theme.DummyChromeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = intent.data?.toString() ?: "the requested content"
        setContent {
            DummyChromeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BlockedScreen(url = url)
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        val url = intent.data?.toString() ?: "the requested content"
        setContent {
            DummyChromeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BlockedScreen(url = url)
                }
            }
        }
    }
}

@Composable
fun BlockedScreen(url: String) {
    val animationNumber = remember { (1..10).random() }

    // The R class will now be resolved correctly
    val animationResId = when (animationNumber) {
        1 -> R.raw.a
        2 -> R.raw.b
        3 -> R.raw.c
        4 -> R.raw.d
        5 -> R.raw.e
        6 -> R.raw.f
        7 -> R.raw.g
        8 -> R.raw.h
        9 -> R.raw.i
        else -> R.raw.j
    }

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationResId))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Access Denied",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Your device is restricted from browsing the internet.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
