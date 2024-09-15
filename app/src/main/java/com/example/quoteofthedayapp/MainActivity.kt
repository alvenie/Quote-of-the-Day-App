package com.example.quoteofthedayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import com.example.quoteofthedayapp.ui.theme.QuoteOfTheDayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Start()
        }
    }
}

@Composable
fun Start(){
    var showText by remember { mutableStateOf(true) }
    val list = listOf("It takes courage to grow up and become who you really are.",
        "Your self-worth is determined by you. You don't have to depend on someone telling you who you are.",
        "Nothing is impossible. The word itself says 'I'm possible!'",
        "Keep your face always toward the sunshine, and shadows will fall behind you.",
        "Don't sit down and wait for the opportunities to come. Get up and make them.",
        "I am lucky that whatever fear I have inside me, my desire to win is always stronger.",
        "Believe you can and you're halfway there.",
        "Don’t count the days, make the days count.",
        "When it comes to luck, you make your own.",
        "There is no better compass than compassion.")

    Column (
        modifier = Modifier
            .fillMaxSize()
            .offset(x = 0.dp, y = 650.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {showText = !showText},
            modifier = Modifier
                .width(200.dp)
                .height(60.dp)
        ) {
            Text(text = "GetQuote",
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
    if (showText or !showText) {
        RandomQuote(
            quote = list[Random.nextInt(list.size)]
        )
    }
}
@Composable
fun RandomQuote(quote: String) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = quote,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    Start()
}