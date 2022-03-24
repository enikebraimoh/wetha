package com.enike.wetha.framework.network.di

import com.enike.core.data.RemoteDataSource
import com.enike.wetha.framework.network.Apis
import com.enike.wetha.framework.network.RemoteDataSourceImpl
import com.enike.wetha.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ng.adashi.network.TokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesClientInterceptor(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                addInterceptor(TokenInterceptor())
            }.build()
    }

    @Provides
    @Singleton
    fun providesGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun providesRetrofitBuilder(gson: Gson, client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit.Builder): Apis {
        return retrofit.build().create(Apis::class.java)
    }

    @Provides
    @Singleton
    fun providesRemoteDataSource(api: Apis): RemoteDataSource = RemoteDataSourceImpl(api)

}