package com.enike.wetha.ui.theme.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enike.core.DataState
import com.enike.core.domain.Weather
import com.enike.core.interactors.GetCityWeatherUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(private val getCoinsUseCase: GetCityWeatherUseCase) : ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init {
        getCityWeather()
    }

    private fun getCityWeather() {
        getCoinsUseCase("").onEach { state ->
            when (state) {
                is DataState.Success<Weather> -> {

                }
                is DataState.Error -> {

                }
                is DataState.GenericError -> {

                }
                DataState.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

}