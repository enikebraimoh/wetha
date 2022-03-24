package com.enike.wetha.framework.network

import com.enike.core.Mappers
import com.enike.core.domain.City
import com.enike.core.domain.Weather

class NetworkMapper() : Mappers<com.enike.wetha.framework.network.models.City, City> {
    override fun mapFromEntity(entity: com.enike.wetha.framework.network.models.City): City {
        return City(
            id = entity.id,
            cityName = entity.name,
            weather = entity.weather.map { weather ->
                Weather(
                    weather.description,
                    weather.icon,
                    weather.id,
                    weather.main
                )
            },
            temperature = com.enike.core.domain.Temperature(
                temp = entity.main.temp,
                temp_min = entity.main.temp_min,
                temp_max = entity.main.temp_max,
                pressure = entity.main.pressure,
                humidity = entity.main.humidity
            ),
            favourite = false
        )
    }

    fun mapFromEntityList(entities: List<com.enike.wetha.framework.network.models.City>): List<City> {
        return entities.map { city -> mapFromEntity(city) }
    }
}