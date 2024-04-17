package com.kotlinrest.mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

object DozerMapper {

    private val mapper: Mapper = DozerBeanMapperBuilder.buildDefault()

    fun <O, D> map(source: O, destination: Class<D>?): D = mapper.map(source, destination)

    fun <O, D> mapList(source: Iterable<O>, destination: Class<D>?) = source.map { mapper.map(it, destination) }

}