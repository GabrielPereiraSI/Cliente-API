package com.br.itau.cliente.api.interactors.strategy

import com.br.itau.cliente.api.configs.exceptions.ValidacaoFlagException
import com.br.itau.cliente.api.datasources.cache.ConsultaFeatureFlag
import com.br.itau.cliente.api.entities.Solicitacao
import org.springframework.stereotype.Component

@Component
class ValidarFlag(private val consultaFlag : ConsultaFeatureFlag) : ValidacaoStrategy{

    override fun validarSolciitacao(solicitacao: Solicitacao) {
        var configs = consultaFlag.buscarConfiguracoes()
        if(configs.idadeMinima < solicitacao.idade){
            throw ValidacaoFlagException("Idade menor que o minimo parametrizado")
        }
        if(configs.salarioMinimo < solicitacao.renda_mensal){
            throw ValidacaoFlagException("salario menor que o minimo parametrizado")
        }
    }
}