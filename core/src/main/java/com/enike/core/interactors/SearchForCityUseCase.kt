package com.enike.core.interactors

import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow

class SearchForCityUseCase constructor(private val homeRepository: HomeRepository) {
    operator fun invoke(searchQuery: String): Flow<List<City>> {
        return homeRepository.searchForCity(searchQuery)
    }

}