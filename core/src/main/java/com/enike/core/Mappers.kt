package com.enike.core


interface Mappers <ENTITY, DOMAIN> {
    fun mapFromEntity(entity: ENTITY) : DOMAIN
}