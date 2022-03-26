package com.enike.wetha.framework

import com.enike.core.data.repository.HomeRepository
import com.enike.core.interactors.*
import com.enike.core.interactors.GetCityWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetAllCitiesUseCase(repo: HomeRepository): GetAllCitiesUseCase =
        GetAllCitiesUseCase(repo)

    @Provides
    fun providesGetCityUseCase(repo: HomeRepository): GetCityWeatherUseCase =
        GetCityWeatherUseCase(repo)

    @Provides
    fun providesGetCityFromDBUseCase(repo: HomeRepository) =
        GetCitiesFromDatabaseUseCase(repo)

    @Provides
    fun providesMakeFavouriteUseCase(repo: HomeRepository) =
        MakeFavouriteUseCase(repo)

    @Provides
    fun providesSearchCityUseCase(repo: HomeRepository) =
        SearchForCityUseCase(repo)


}