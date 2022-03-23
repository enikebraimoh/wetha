package com.enike.core.data

import com.enike.core.domain.Weather

interface LocalDataSource {

    suspend fun getAllCitesWeather() : List<Weather>

}