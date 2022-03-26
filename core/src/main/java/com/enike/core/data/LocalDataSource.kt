package com.enike.core.data

import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun addCityWeather(city: City) : Long
    suspend fun getAllCitesWeather(): List<City>
    suspend fun searchForCity(searchQuery: String): List<City>
    suspend fun makeFavourite(city : City)

}