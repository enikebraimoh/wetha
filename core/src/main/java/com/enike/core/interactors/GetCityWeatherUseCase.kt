package com.enike.core.interactors

import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow

class GetCityWeatherUseCase
constructor
    (private val homeRepository: HomeRepository) {
    operator fun invoke(city: String): Flow<City> {
        return homeRepository.getCityWeather(city)
    }
}

