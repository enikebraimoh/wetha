package com.enike.wetha.framework.database

import com.enike.core.Mappers
import com.enike.core.domain.Temperature
import com.enike.core.domain.Weather
import com.enike.wetha.framework.database.models.City

class DatabaseMapper : Mappers<City, com.enike.core.domain.City> {
    override fun mapFromEntity(entity: City): com.enike.core.domain.City {
        return com.enike.core.domain.City(
            id = entity.id,
            cityName = entity.cityName,
            weather = listOf(
                Weather(
                    entity.description,
                    entity.icon,
                    entity.id,
                    entity.main
                )
            ),
            temperature = Temperature(
                temp = entity.temp,
                temp_min = entity.temp_min,
                temp_max = entity.temp_max,
                pressure = entity.pressure,
                humidity = entity.humidity
            ),
            favourite = entity.favourite
        )
    }

    fun mapToEntity(entity: com.enike.core.domain.City): City {
        return City(
            id = entity.id,
            cityName = entity.cityName,
            favourite = entity.favourite,
            humidity = entity.temperature.humidity,
            pressure = entity.temperature.pressure,
            temp = entity.temperature.temp,
            temp_max = entity.temperature.temp_max,
            temp_min = entity.temperature.temp_min,
            description = entity.weather[0].description,
            icon = entity.weather[0].icon,
            main = entity.weather[0].main,
        )
    }

    fun mapFromEntityList(entities: List<City>): List<com.enike.core.domain.City> {
        return entities.map { city -> mapFromEntity(city) }
    }


}