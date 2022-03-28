package com.enike.wetha.framework.repository

import android.util.Log
import com.enike.core.data.LocalDataSource
import com.enike.core.data.RemoteDataSource
import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : HomeRepository {

    override fun getCityWeather(city: String): Flow<City> = flow {
        try {
            val response = remoteDataSource.getCityWeather(city)
            emit(response)
        } catch (e: Exception) {
            Log.d("ERROR_TESTING_REPO", e.localizedMessage)
        }
    }


    override fun getAllCityWeather(cities: List<String>): Flow<List<City>> = flow {
        try {
            val result = mutableListOf<City>()
            for (city in cities) {
                val res = remoteDataSource.getCityWeather(city)
                localDataSource.addCityWeather(res)
                result.add(res)
            }
            val localData = localDataSource.getAllCitesWeather()
            emit(localData)

        } catch (e: Exception) {
            val localData = localDataSource.getAllCitesWeather()
            emit(localData)
            Log.d("ERROR_TESTING_REPO", e.localizedMessage)
        }
    }

    override fun getDatabaseCityWeather(): Flow<List<City>> = flow {
        try {
            val localData = localDataSource.getAllCitesWeather()
            emit(localData)
        } catch (e: Exception) {
            Log.d("ERROR_TESTING_REPO", e.localizedMessage.toString())
        }
    }

    override fun searchForCity(searchQuery: String) = flow {
        try {
            emit(localDataSource.searchForCity(searchQuery))
        } catch (e: Exception) {
            Log.d("ERROR_TESTING_REPO", e.localizedMessage.toString())
        }
    }

    override suspend fun makeFavourite(city: City) {
        try {
            localDataSource.makeFavourite(city)
        } catch (e: Exception) {
            Log.d("ERROR_TESTING_REPO", e.localizedMessage.toString())
        }
    }

}
