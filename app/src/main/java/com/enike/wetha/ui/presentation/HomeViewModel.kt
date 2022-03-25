package com.enike.wetha.ui.presentation

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.enike.core.domain.City
import com.enike.core.interactors.GetAllCitiesUseCase
import com.enike.core.interactors.GetCitiesFromDatabaseUseCase
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
    private val getAllCitiesUseCase: GetAllCitiesUseCase,
    private val getCitiesFromDatabaseUseCase: GetCitiesFromDatabaseUseCase,
    private val app: Application
) : AndroidViewModel(app) {

    private val _state: MutableState<List<City>> = mutableStateOf(listOf())
    val state: State<List<City>> = _state

    val listOfCities = listOf("london", "lagos", "abuja", "nairobi", "kano", "dutse")

    init {
        getAllCitiesWeathers(listOfCities)
        getCitiesFromDB()
    }

    private fun getCityWeather(country: String) {
        getWeatherUseCase(country).onEach { city ->
        }.launchIn(viewModelScope)
    }

    //get all cities weather from db
    private fun getCitiesFromDB() {
        getCitiesFromDatabaseUseCase().onEach { cities ->
            _state.value = cities
        }.launchIn(viewModelScope)
    }

    //get all cities weather from network and save to db
    private fun getAllCitiesWeathers(cities: List<String>) {
        getAllCitiesUseCase(cities).onEach {
            getCitiesFromDB()

        }.launchIn(viewModelScope)

    }

}