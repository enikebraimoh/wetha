package com.enike.wetha.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.WbCloudy
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enike.core.domain.City
import com.enike.core.domain.Weather
import com.enike.wetha.R
import com.enike.wetha.presentation.ui.theme.WethaTheme

@Composable
fun GlassCard(
    icon: ImageVector,
    temperature: Double,
    place: String,
    city: City,
    clicked : (city : City) -> Unit,
    makeFavourite: (city: City) -> Unit
) {
    var favourite by remember { mutableStateOf(false) }

    var tint = if (icon == Icons.Rounded.WbSunny) {
        Color(0xFFE9E38C)
    } else if (icon == Icons.Rounded.WbCloudy) {
        Color(0xFF5CA9E6)
    } else {
        Color(0xFFFFFFFF)
    }

    Card(
        modifier = Modifier
            .padding(top = 20.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(150.dp), backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, Color(0x25FFFFFF)),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp),
        onClick = {clicked(city)}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(1f)
                .blur(28.dp, BlurredEdgeTreatment.Unbounded)
                .background(
                    Brush.radialGradient(
                        listOf(
                            Color(0x12FFFFFF),
                            Color(0xDFFFFFF),
                            Color(0x9FFFFFFF)
                        ),
                        radius = 2200f,
                        center = Offset.Infinite
                    )

                )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Sunny",
                modifier = Modifier.size(80.dp),
                tint = tint
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = "max ${temperature}°",
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = place,
                    style = MaterialTheme.typography.body1
                )

            }
            Spacer(modifier = Modifier.width(20.dp))

            IconButton(onClick = { makeFavourite(addCity(city)) }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favourite),
                    contentDescription = "favourite icon",
                    colorFilter = if (!city.favourite) ColorFilter.tint(Color.Gray) else ColorFilter.tint(
                        Color.Red
                    )
                )
            }

        }

    }
}

fun addCity(city: City): City {
    val newCity = City(
        id = city.id,
        cityName = city.cityName,
        weather = city.weather.map { weather ->
            Weather(
                weather.description,
                weather.icon,
                weather.id,
                weather.main
            )
        },
        temperature = com.enike.core.domain.Temperature(
            temp = city.temperature.temp,
            temp_min = city.temperature.temp_min,
            temp_max = city.temperature.temp_max,
            pressure = city.temperature.pressure,
            humidity = city.temperature.humidity
        ),
        favourite = city.favourite.not()
    )
    return newCity

}

@Preview(showBackground = false)
@Composable
fun MyPreview() {
    WethaTheme {
        Surface(color = MaterialTheme.colors.background) {

        }
    }
}