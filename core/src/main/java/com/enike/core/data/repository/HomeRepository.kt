package com.enike.core.data.repository

import com.enike.core.DataState
import com.enike.core.domain.Weather
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
     fun getCityWeather(city: String): Flow<DataState<Weather>>
}