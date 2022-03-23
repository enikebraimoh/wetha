package com.enike.wetha.framework.network

import com.enike.core.DataState
import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCityWeatherUseCase
@Inject
constructor
    (val homeRepository: HomeRepository) {
    operator fun invoke(city: String): Flow<DataState<City>> {
        return homeRepository.getCityWeather(city)
    }
}

