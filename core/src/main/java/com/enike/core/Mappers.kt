package com.enike.core

import javax.swing.text.html.parser.Entity

interface Mappers <ENTITY, DOMAIN> {
    fun mapFromEntity(entity: ENTITY) : DOMAIN
}