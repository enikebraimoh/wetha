package com.enike.wetha.framework.network.models

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)