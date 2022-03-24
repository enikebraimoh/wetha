package com.enike.wetha.framework.database.models

import androidx.room.ColumnInfo

data class Weather(
    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "icon")
    val icon: String,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "main")
    val main: String
)