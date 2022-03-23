package com.enike.wetha.framework.network

import com.enike.wetha.framework.network.models.City
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET("weather")
    suspend fun getCityWeather(@Query("q") city: String): City

    @GET("weather")
    suspend fun getAllCityWeather(city: String): List<City>
}