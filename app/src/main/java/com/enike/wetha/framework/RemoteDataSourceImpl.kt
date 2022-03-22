package com.enike.wetha.framework

import com.enike.core.data.RemoteDataSource
import com.enike.core.domain.Weather
import com.enike.wetha.framework.network.Apis
import javax.inject.Inject

class RemoteDataSourceImpl
@Inject
constructor(private val api: Apis) : RemoteDataSource {
    override suspend fun getCityWeather(city: String): Weather {
        return api.getCityWeather(city = city)
    }

}