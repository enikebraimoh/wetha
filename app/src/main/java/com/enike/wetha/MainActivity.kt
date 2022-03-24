package com.enike.wetha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.enike.wetha.ui.presentation.HomeViewModel
import com.enike.wetha.ui.theme.WethaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WethaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Mother Fucker!")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val viewModel: HomeViewModel = hiltViewModel()
    val cities by remember { viewModel.state }
    Text(text = cities.toString())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WethaTheme {
        Greeting("Android")
    }
}