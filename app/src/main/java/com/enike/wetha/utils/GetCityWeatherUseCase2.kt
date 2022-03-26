package com.enike.wetha.utils

import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCityWeatherUseCase2
@Inject
constructor(private val homeRepository: HomeRepository) {
    operator fun invoke(city: String): Flow<City> {
        return homeRepository.getCityWeather(city)
    }
}

