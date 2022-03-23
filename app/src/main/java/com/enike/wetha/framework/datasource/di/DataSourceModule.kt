package com.enike.wetha.framework.datasource.di

import com.enike.core.data.RemoteDataSource
import com.enike.wetha.framework.datasource.RemoteDataSourceImpl
import com.enike.wetha.framework.network.Apis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource (api : Apis) : RemoteDataSource = RemoteDataSourceImpl(api)

}