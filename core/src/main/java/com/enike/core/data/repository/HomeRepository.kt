package com.enike.core.data.repository

import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getCityWeather(city: String): Flow<City>
    fun getAllCityWeather(cities: List<String>): Flow<List<City>>
    fun getDatabaseCityWeather(): Flow<List<City>>
}