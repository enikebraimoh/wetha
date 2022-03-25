package com.enike.wetha.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material.icons.rounded.WbCloudy
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enike.core.domain.City
import com.enike.core.domain.Temperature
import com.enike.core.domain.Weather
import com.enike.wetha.R
import com.enike.wetha.ui.components.GlassCard
import com.enike.wetha.ui.theme.WethaTheme

@Composable
fun Home(data: List<City>) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize()
                .blur(7.dp),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xDD000000)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items = data) { data ->
                    var icon = if (data.weather[0].icon.equals("40d")) {
                        Icons.Rounded.AcUnit
                    } else if (data.weather[0].icon.equals("50d")) {
                        Icons.Rounded.WbCloudy
                    } else {
                        Icons.Rounded.WbSunny
                    }

                    GlassCard(
                        icon = icon,
                        temperature = data.temperature.temp,
                        place = data.cityName
                    )
                }
            }
        }
    }

}


@Composable
@Preview(showBackground = false)
fun MyPreview() {
    WethaTheme {
        Surface(color = MaterialTheme.colors.background) {
            Home(
                data = listOf(
                    City(
                        Temperature(
                            2,
                            2,
                            2.8,
                            22.2,
                            22.2
                        ),
                        listOf(
                            Weather(
                                "",
                                "50d", 222, ""
                            )
                        ),
                        "abuja",
                        224,
                        true
                    ),
                    City(
                        Temperature(
                            2,
                            2,
                            2.8,
                            22.2,
                            22.2
                        ),
                        listOf(
                            Weather(
                                "",
                                "30d", 222, ""
                            )
                        ),
                        "Lagos",
                        224,
                        true
                    ),
                    City(
                        Temperature(
                            2,
                            2,
                            2.8,
                            22.2,
                            22.2
                        ),
                        listOf(
                            Weather(
                                "",
                                "30d", 222, ""
                            )
                        ),
                        "Lagos",
                        224,
                        true
                    ),
                    City(
                        Temperature(
                            2,
                            2,
                            2.8,
                            22.2,
                            22.2
                        ),
                        listOf(
                            Weather(
                                "",
                                "30d", 222, ""
                            )
                        ),
                        "Lagos",
                        224,
                        true
                    )
                )
            )
        }
    }
}


