package com.enike.wetha.ui.presentation

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.enike.core.domain.City
import com.enike.core.interactors.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor
    (
    private val getWeatherUseCase: GetCityWeatherUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase,
    private val getCitiesFromDatabaseUseCase: GetCitiesFromDatabaseUseCase,
    private val makeCityFavouriteUseCase: MakeFavouriteUseCase,
    private val searchQueryUseCase: SearchForCityUseCase,
    private val app: Application
) : AndroidViewModel(app) {

    private val _state: MutableState<List<City>> = mutableStateOf(listOf())
    val state: State<List<City>> = _state

    val listOfCities = listOf("london", "lagos", "lagos", "abuja", "nairobi", "kano", "dutse")

    init {
        getAllCitiesWeathers(listOfCities)
        getCitiesFromDB()
    }

    private fun getCityWeather(country: String) {
        getWeatherUseCase(country).onEach { city ->
        }.launchIn(viewModelScope)
    }

    fun searchForCity(searchQuery: String) {
        searchQueryUseCase("%$searchQuery%").onEach { cities ->
            _state.value = cities
        }.launchIn(viewModelScope)
    }

    //get all cities weather from db
    fun makeCityFavourite(city: City) {
        viewModelScope.launch {
            makeCityFavouriteUseCase(city)
            getCitiesFromDB()
        }
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