package com.enike.wetha.di

import com.enike.core.data.RemoteDataSource
import com.enike.wetha.framework.RemoteDataSourceImpl
import com.enike.wetha.framework.network.Apis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesNetworkDataSource (apis : Apis) : RemoteDataSource{
        return RemoteDataSourceImpl(apis)
    }

}