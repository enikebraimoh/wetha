package com.enike.core.data

import com.enike.core.domain.Weather

interface RemoteDataSource {
    suspend fun getCityWeather(city : String) : Weather
}