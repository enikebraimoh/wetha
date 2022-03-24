package com.enike.wetha.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.enike.wetha.framework.database.models.City


@Database(entities = [City::class], version = 2)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {
        const val DB_NAME = "wetha_database"
    }

}