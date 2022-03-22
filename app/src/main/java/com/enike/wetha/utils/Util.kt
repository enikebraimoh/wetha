package com.enike.wetha.utils

import com.enike.core.ErrorResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException


fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.charStream()?.let {
            val type = object : TypeToken<ErrorResponse>() {}.type
            Gson().fromJson(it, type)
        }
    } catch (exception: Exception) {
        null
    }
}