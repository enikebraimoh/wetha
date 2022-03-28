package com.enike.wetha.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material.icons.rounded.WbCloudy
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enike.core.domain.City
import com.enike.wetha.presentation.ui.theme.WethaTheme

@Composable
fun DetailsScreen(arg: City?) {

    val icon = if (arg?.weather?.get(0)?.icon.equals("40d")) {
        Icons.Rounded.AcUnit
    } else if (arg?.weather?.get(0)?.icon.equals("50d")) {
        Icons.Rounded.WbCloudy
    } else {
        Icons.Rounded.WbSunny
    }

    var tint = if (icon == Icons.Rounded.WbSunny) {
        Color(0xFFE9E38C)
    } else if (icon == Icons.Rounded.WbCloudy) {
        Color(0xFF5CA9E6)
    } else {
        Color(0xFFFFFFFF)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            imageVector = icon,
            contentDescription = "icon",
            colorFilter = ColorFilter.tint(tint)
        )

        Spacer(modifier = Modifier.size(50.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = "City name -> ${arg?.cityName!!}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "weather -> ${arg.weather[0].description} ",
                style = MaterialTheme.typography.body1
            )
        }

        Spacer(modifier = Modifier.size(20.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = "clouds -> ${arg?.weather?.get(0)?.main!!}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Humidity -> ${arg.temperature.humidity.toString()}",
                style = MaterialTheme.typography.body1
            )
        }

        Spacer(modifier = Modifier.size(20.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Pressure -> ${arg?.temperature?.pressure.toString()}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Temperature -> ${arg?.temperature?.temp.toString()}",
                style = MaterialTheme.typography.body1
            )
        }

    }
}

@Composable
@Preview
fun Previeww() {
    WethaTheme {

    }
}