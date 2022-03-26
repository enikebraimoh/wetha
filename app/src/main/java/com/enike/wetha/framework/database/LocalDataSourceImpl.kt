package com.enike.wetha.framework.database

import android.util.Log
import com.enike.core.data.LocalDataSource
import com.enike.core.domain.City

class LocalDataSourceImpl(val data: CityDao) : LocalDataSource {
    override suspend fun addCityWeather(city: City): Long {
        return data.insertCities(DatabaseMapper().mapToEntity(city))
    }

    override suspend fun getAllCitesWeather(): List<City> {
        return DatabaseMapper().mapFromEntityList(data.getAllCities())
    }

    override suspend fun searchForCity(searchQuery: String): List<City> {
        return DatabaseMapper().mapFromEntityList(data.searchForCity(searchQuery))
    }

    override suspend fun makeFavourite(city: City) {
        data.makeFavourite(DatabaseMapper().mapToEntity(city))
    }
}