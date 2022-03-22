package com.enike.core.interactors

import com.enike.core.DataState
import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.Weather
import kotlinx.coroutines.flow.Flow

class GetCityWeatherUseCase(private val homeRepository: HomeRepository) {
    operator fun invoke(city: String): Flow<DataState<Weather>> {
        return homeRepository.getCityWeather(city)
    }

}