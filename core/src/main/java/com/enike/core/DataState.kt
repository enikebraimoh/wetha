package com.enike.core

sealed class DataState<out T> {
    data class Success<out R>(val data: R) : DataState<R>()
    data class Error(val error: Throwable) : DataState<Nothing>()
    data class GenericError(
        val code: Int? = null,
        val error: ErrorResponse? = null
    ) : DataState<Nothing>()

    object Loading : DataState<Nothing>()

}

data class ErrorResponse(val status: String, val message: String)