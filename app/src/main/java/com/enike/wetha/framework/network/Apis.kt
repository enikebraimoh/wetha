package com.enike.wetha.framework.network

import com.enike.core.domain.Weather
import retrofit2.http.GET

interface Apis {

    @GET("auth/signup")
    suspend fun getCityWeather(city: String): Weather
}