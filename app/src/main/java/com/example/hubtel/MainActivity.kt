package com.example.hubtel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.hubtel.ui.HomeScreen
import com.example.hubtel.ui.theme.HubtelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.nunito_regular,FontWeight.Thin),
            Font(R.font.nunito_bold,FontWeight.Bold),
            Font(R.font.nunito_extrabold,FontWeight.ExtraBold),
            Font(R.font.nunito_semibold,FontWeight.SemiBold),
            Font(R.font.nunito_light,FontWeight.Light),
            Font(R.font.nunito_black,FontWeight.Black)

        )
        setContent {
            HubtelTheme {
                // A surface container using the 'background' color from the theme
               HomeScreen(fontFamily)
            }
        }
    }
}


//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    HubtelTheme {
//        Greeting("Android")
//    }
//}