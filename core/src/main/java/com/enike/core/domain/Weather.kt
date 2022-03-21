package com.enike.core.domain

data class Weather(
    val City: String,
    val State: String,
    val description: String,
    val main: String,
    val temp : Temperature
)
