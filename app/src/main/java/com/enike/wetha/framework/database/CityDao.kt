package com.enike.wetha.framework.database

import androidx.room.*
import com.enike.wetha.framework.database.models.City

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(city: City): Long

    @Query("SELECT * FROM city_table ORDER BY favourite DESC")
    suspend fun getAllCities(): MutableList<City>

    @Query("SELECT * FROM city_table WHERE cityName LIKE :searchQuery")
    suspend fun searchForCity(searchQuery: String): List<City>

    @Update
    suspend fun makeFavourite(city: City)



}