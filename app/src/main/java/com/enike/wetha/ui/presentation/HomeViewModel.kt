package com.enike.wetha.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enike.core.domain.City
import com.enike.core.interactors.GetAllCitiesUseCase
import com.enike.core.interactors.GetCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor
    (
    private val getWeatherUseCase: GetCityWeatherUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase
) : ViewModel() {

    private val _state: MutableState<List<City>> = mutableStateOf(listOf())
    val state: State<List<City>> = _state

    val listOfCities = listOf("london", "lagos", "abuja")

    init {
        getAllCitiesWeathers(listOfCities)
    }

    private fun getCityWeather(country: String) {
        getWeatherUseCase(country).onEach { city ->

        }.launchIn(viewModelScope)
    }

    private fun getAllCitiesWeathers(cities: List<String>) {
        getAllCitiesUseCase(cities).onEach { cities ->
            _state.value = cities
        }.launchIn(viewModelScope)
    }

}