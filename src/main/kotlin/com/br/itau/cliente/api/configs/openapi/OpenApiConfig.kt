package com.br.itau.cliente.api.configs.openapi

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("API de Cliente Itaú")
                    .description("API para solicitação de cartões")
                    .version("v1.0.0")
            )
    }
}