package com.enike.wetha.ui.theme.presentation

import com.enike.core.domain.Temperature
import com.enike.core.domain.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val data: Weather = Weather(
        City = "",
        State = "",
        description = "",
        main = "",
        temp = Temperature("","","","","")
    ),
    val error: String = ""
)
