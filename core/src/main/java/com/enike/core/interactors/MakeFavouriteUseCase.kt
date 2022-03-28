package com.enike.core.interactors

import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City

class MakeFavouriteUseCase(private val homeRepository: HomeRepository) {
    suspend operator fun invoke(city: City) {
        homeRepository.makeFavourite(city)
    }

}