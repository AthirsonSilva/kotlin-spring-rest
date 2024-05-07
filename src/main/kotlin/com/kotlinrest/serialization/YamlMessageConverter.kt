package com.kotlinrest.serialization

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.springframework.http.MediaType
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter

class YamlMessageConverter : AbstractJackson2HttpMessageConverter(
    YAMLMapper().setSerializationInclusion(
        JsonInclude.Include.NON_NULL
    ),
    MediaType.parseMediaType("application/x-yaml")
) {
    companion object {
        const val MEDIA_TYPE_YAML = "application/x-yaml"
    }
}