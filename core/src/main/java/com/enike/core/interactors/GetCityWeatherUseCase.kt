package com.enike.core.interactors

import com.enike.core.DataState
import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import com.enike.core.domain.Weather
import kotlinx.coroutines.flow.Flow

class GetCityWeatherUseCase
constructor
    (private val homeRepository: HomeRepository) {
    operator fun invoke(city: String): Flow<DataState<City>> {
        return homeRepository.getCityWeather(city)
    }
}

