package com.enike.wetha.framework.database

import androidx.room.TypeConverter
import com.enike.wetha.framework.database.models.City
import com.enike.wetha.framework.database.models.Temperature
import com.enike.wetha.framework.database.models.Weather
import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun cityToJson(temp: List<City>): String = Json.encodeToString(temp)

    @TypeConverter
    fun cityFromJson(json: String): List<City> = Json.decodeFromString(json)

    @TypeConverter
    fun fromList(meals: MutableList<String>?) = Gson().toJson(meals)

    @TypeConverter
    fun fromString(value: String?) = Gson().fromJson(value,Array<String>::class.java)?.toMutableList()

}