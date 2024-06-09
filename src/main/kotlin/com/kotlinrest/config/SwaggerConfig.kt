package com.kotlinrest.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openApi(): OpenAPI {
        val info = Info()
            .title("Kotlin REST API")
            .description("Kotlin REST API documentation")
            .version("1.0.0")

        return OpenAPI()
            .info(info)
    }

}