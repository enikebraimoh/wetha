package com.enike.wetha.framework.network

import com.enike.core.data.RemoteDataSource
import com.enike.core.domain.City
import com.enike.wetha.framework.network.Apis
import com.enike.wetha.framework.network.NetworkMapper

class RemoteDataSourceImpl
constructor(private val api: Apis) : RemoteDataSource {

    override suspend fun getCityWeather(city: String): City {
        return NetworkMapper().mapFromEntity(api.getCityWeather(city))
    }

    override suspend fun getAllCityWeather(cities: String): List<City> {
        return NetworkMapper().mapFromEntityList(api.getAllCityWeather(cities))
    }
}