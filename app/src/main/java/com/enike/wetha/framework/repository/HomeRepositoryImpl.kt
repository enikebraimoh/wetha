package com.enike.wetha.framework.repository

import android.util.Log
import com.enike.core.DataState
import com.enike.core.data.RemoteDataSource
import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.City
import com.enike.core.domain.Weather
import com.enike.wetha.utils.convertErrorBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class HomeRepositoryImpl(private val remoteDataSource: RemoteDataSource) : HomeRepository {

    override fun getCityWeather(city: String): Flow<DataState<City>> = flow {
        emit(DataState.Loading)
        try {
            val response = remoteDataSource.getCityWeather(city)
            emit(DataState.Success(response))
            Log.d("MYTEST",response.toString())
        } catch (e: Exception) {
            Log.d("MYTEST",e.toString())
            when (e) {
                is IOException -> emit(DataState.Error(e))
                is HttpException -> {
                    val status = e.code()
                    val res = convertErrorBody(e)
                    emit(DataState.GenericError(status, res))
                }
            }
        }
    }

    override fun getAllCityWeather(city: String): Flow<DataState<List<City>>> = flow {
        emit(DataState.Loading)
        try {

            val response = remoteDataSource.getCityWeather(city)
            DataState.Success(response)

        } catch (e: Exception) {
            when (e) {
                is IOException -> emit(DataState.Error(e))
                is HttpException -> {
                    val status = e.code()
                    val res = convertErrorBody(e)
                    emit(DataState.GenericError(status, res))
                }
            }
        }
    }

}
