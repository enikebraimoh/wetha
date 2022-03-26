package com.enike.wetha.utils

import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCitiesFromDatabaseUseCase2
@Inject
constructor(private val homeRepository: HomeRepository) {
    operator fun invoke(): Flow<List<City>> {
        return homeRepository.getDatabaseCityWeather()
    }
}