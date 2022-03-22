package com.enike.wetha.framework.repository

import com.enike.core.DataState
import com.enike.core.data.RemoteDataSource
import com.enike.core.data.repository.HomeRepository
import com.enike.core.domain.Weather
import com.enike.wetha.ui.theme.presentation.WeatherState
import com.enike.wetha.utils.convertErrorBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class HomeRepositoryImpl
@Inject
constructor(private val remoteDataSource: RemoteDataSource) : HomeRepository {

    override fun getCityWeather(city: String): Flow<DataState<Weather>> = flow {
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
