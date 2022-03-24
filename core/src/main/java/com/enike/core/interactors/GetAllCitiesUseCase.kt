package com.enike.core.interactors

import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow

class GetAllCitiesUseCase
constructor(private val homeRepository: HomeRepository) {
    operator fun invoke(cities: List<String>): Flow<List<City>> {
        return homeRepository.getAllCityWeather(cities)
    }

}