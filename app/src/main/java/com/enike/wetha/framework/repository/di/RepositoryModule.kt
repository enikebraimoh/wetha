package com.enike.wetha.framework.repository.di

import com.enike.core.data.RemoteDataSource
import com.enike.core.data.repository.HomeRepository
import com.enike.wetha.framework.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesHomeRepository(dataSource: RemoteDataSource): HomeRepository =
        HomeRepositoryImpl(dataSource)

}