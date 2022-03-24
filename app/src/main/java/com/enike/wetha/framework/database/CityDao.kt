package com.enike.wetha.framework.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.enike.wetha.framework.database.models.City

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(city: City) : Long

    @Query("SELECT * FROM city_table ORDER BY favourite")
    suspend fun getAllCities(): MutableList<City>

}