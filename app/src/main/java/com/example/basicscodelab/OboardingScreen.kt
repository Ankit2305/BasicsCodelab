package com.example.basicscodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit = {}) {
    Surface(
        color = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to Basics Codelab",
                modifier = Modifier.padding(vertical = 24.dp)
            )
            Button(onClick = onContinueClicked) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(widthDp = 320, heightDp = 320, showBackground = true)
@Composable
fun OnBoardingPreview() {
    BasicsCodelabTheme {
        OnBoardingScreen()
    }
}
