package com.example.arquivomobileoficialnitro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.ui.theme.ArquivoMobileOficialNitroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArquivoMobileOficialNitroTheme {
                GradientBackground {
                    Greeting(name = "Android")
                }
            }
        }
    }
}

@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF000B21), // Início do gradiente (54.57%)
            Color(0xFF22436B)  // Fim do gradiente (100%)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        color = Color.White // Melhor contraste com o fundo escuro
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArquivoMobileOficialNitroTheme {
        GradientBackground {
            Greeting("Android")
        }
    }
}
