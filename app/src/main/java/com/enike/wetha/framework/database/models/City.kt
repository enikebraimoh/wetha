package com.enike.wetha.framework.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class City(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "cityName")
    var cityName: String,

    @ColumnInfo(name = "favourite")
    var favourite: Boolean,

    @ColumnInfo(name = "humidity")
    var humidity: Int,

    @ColumnInfo(name = "pressure")
    var pressure: Int,

    @ColumnInfo(name = "temp")
    var temp: Double,

    @ColumnInfo(name = "temp_max")
    var temp_max: Double,

    @ColumnInfo(name = "temp_min")
    var temp_min: Double,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "icon")
    var icon: String,

    @ColumnInfo(name = "main")
    var main: String
)