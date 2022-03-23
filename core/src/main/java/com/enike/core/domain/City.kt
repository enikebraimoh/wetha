package com.enike.core.domain

data class City(
    val temperature: Temperature,
    val weather: List<Weather>,
    val cityName: String,
    val id: Int
)