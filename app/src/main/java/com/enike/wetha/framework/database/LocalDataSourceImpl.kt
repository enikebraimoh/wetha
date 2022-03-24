package com.enike.wetha.framework.database

import com.enike.core.data.LocalDataSource
import com.enike.core.domain.City

class LocalDataSourceImpl(val data: CityDao) : LocalDataSource {
    override suspend fun addCityWeather(city: City): Long {
        return data.insertCities(DatabaseMapper().mapToEntity(city))
    }

    override suspend fun getAllCitesWeather(): List<City> {
        return DatabaseMapper().mapFromEntityList(data.getAllCities())
    }
}