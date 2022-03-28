package com.enike.core.domain

import java.io.Serializable


data class City(
    val temperature: Temperature,
    val weather: List<Weather>,
    val cityName: String,
    val id: Int,
    var favourite: Boolean
) : Serializable