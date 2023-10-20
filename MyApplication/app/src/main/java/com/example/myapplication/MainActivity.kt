package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Game() {
    MyApplicationTheme {
        GameScreen()
    }
}

//@Preview
@Composable
fun GameScreen() {
    var targetValue by remember { mutableStateOf((0..100).random()) }
    var playerValue by remember { mutableStateOf(50f) }
    var score by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bulls Eye",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = "Move the slider as close as you can to : $targetValue",
            fontSize = 15.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(130.dp))
        Slider(
            value = playerValue,
            onValueChange = {
                playerValue = it
            },
            valueRange = 0f..100f,
            steps = 1,
            //colors = SliderDefaults.colors(Color.Magenta)

        )
        Spacer(modifier = Modifier.height(80.dp))
        Button(
                    onClick = {
                val difference = (targetValue - playerValue).toInt()
                when {
                    difference in -3..3 -> {
                        score += 5
                    }
                    difference in -8..8 -> {
                        score += 1
                    }
                }
                targetValue = (0..100).random()
                playerValue = 50f
            },
            //colors = ButtonDefaults.buttonColors(Color.Magenta)

        ) {
            Text("Hit Me!")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Score: $score",
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}