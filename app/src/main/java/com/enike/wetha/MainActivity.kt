package com.enike.wetha

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enike.core.domain.City
import com.enike.wetha.presentation.Home
import com.enike.wetha.presentation.ui.Screens.HomeScreen
import com.enike.wetha.presentation.ui.Screens.WeatherDetailsScreen
import com.enike.wetha.presentation.ui.home.DetailsScreen
import com.enike.wetha.presentation.ui.theme.WethaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WethaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }

        createChannel(
            getString(R.string.notification_channel_id),
            getString(R.string.notification_channel_name)
        )
    }

    private fun createChannel(channelId: String, channelName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,

                NotificationManager.IMPORTANCE_HIGH
            )
                .apply {
                    setShowBadge(false)
                }

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = getString(R.string.notification_channel_description)

            val notificationManager = this.getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

}


@Composable
fun App() {

    //nav
    val navController = rememberNavController()

    Scaffold { paddingValues ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }

}

@Composable
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    androidx.navigation.compose.NavHost(
        startDestination = HomeScreen.name,
        navController = navController,
        modifier = modifier
    ) {
        composable(HomeScreen.name) {
            Home(navigate = { city ->
                navController.currentBackStackEntry?.savedStateHandle?.set("city", city)
                navController.navigate(WeatherDetailsScreen.name)
            })
        }
        composable(WeatherDetailsScreen.name) {
            val city = navController.previousBackStackEntry?.savedStateHandle?.get<City>("city")
            DetailsScreen(arg = city)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WethaTheme {
        App()
    }
}