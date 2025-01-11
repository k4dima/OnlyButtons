package com.example.onlybuttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.onlybuttons.ui.theme.OnlyButtonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnlyButtonsTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        if (false) GreenButton({}, "Старт")
        else if (true) BlueButton({}, "Cancel")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OnlyButtonsTheme {
        Greeting()
    }
}