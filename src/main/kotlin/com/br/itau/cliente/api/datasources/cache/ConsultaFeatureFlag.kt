package com.br.itau.cliente.api.datasources.cache

import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ConsultaFeatureFlag {
    private val default = FlagConfig()

    @Cacheable("configuracoes")
    fun buscarConfiguracoes(): FlagConfig {
        println("Retornando valores padrões por ausência no cache.")
        return default
    }

    @CachePut("configuracoes")
    fun atualizarConfiguracoes(config: FlagConfig): FlagConfig {
        println("Atualizando valores no cache: $config")
        return config
    }

    @CacheEvict("configuracoes")
    fun limparConfiguracoes() {
        println("Cache de configurações limpo.")
    }
}