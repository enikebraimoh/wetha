package com.enike.core.data

import com.enike.core.domain.City

interface RemoteDataSource {
    suspend fun getCityWeather(city: String): City
    suspend fun getAllCityWeather(cities: String): List<City>
}