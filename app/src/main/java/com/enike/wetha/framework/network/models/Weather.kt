package com.enike.wetha.framework.network.models

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("")
    val City: String,
    @SerializedName("")
    val State: String,
    @SerializedName("")
    val description: String,
    @SerializedName("")
    val main: String,
    @SerializedName("")
    val temp : Temperature
)
