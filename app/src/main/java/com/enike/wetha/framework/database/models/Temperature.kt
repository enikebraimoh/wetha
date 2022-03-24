package com.enike.wetha.framework.database.models

import androidx.room.ColumnInfo

data class Temperature(
    @ColumnInfo(name = "humidity")
    val humidity: Int,

    @ColumnInfo(name = "pressure")
    val pressure: Int,

    @ColumnInfo(name = "temp")
    val temp: Double,

    @ColumnInfo(name = "temp_max")
    val temp_max: Double,

    @ColumnInfo(name = "temp_min")
    val temp_min: Double
)
