package com.enike.wetha.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AcUnit
import androidx.compose.material.icons.rounded.WbCloudy
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.enike.core.domain.City
import com.enike.core.domain.Weather
import com.enike.wetha.R
import com.enike.wetha.presentation.ui.components.CustomInputField
import com.enike.wetha.presentation.ui.components.GlassCard
import com.enike.wetha.presentation.ui.home.HomeViewModel


@Composable
fun Home( navigate : (city : City) -> Unit) {

    val viewModel: HomeViewModel = hiltViewModel()
    val data by remember { viewModel.state }
    val (text, setText) = remember { mutableStateOf("") }
    val context = LocalContext.current

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
            CustomInputField(
                text = text,
                hint = "Search for a city",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onTextChange = {
                    setText(it)
                    viewModel.searchForCity(it)
                })

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items = data) { data ->
                    val icon = if (data.weather[0].icon.equals("40d")) {
                        Icons.Rounded.AcUnit
                    } else if (data.weather[0].icon.equals("50d")) {
                        Icons.Rounded.WbCloudy
                    } else {
                        Icons.Rounded.WbSunny
                    }

                    GlassCard(
                        icon = icon,
                        temperature = data.temperature.temp,
                        place = data.cityName,
                        city = data,
                        makeFavourite = {
                            viewModel.makeCityFavourite(it)
                        },
                        clicked = {
                            navigate(it)
                        }
                    )
                }
            }
        }
    }
}



