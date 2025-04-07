package com.br.itau.cliente.api.interactors

import com.br.itau.cliente.api.datasources.SolicitacaoDataSource
import com.br.itau.cliente.api.entities.Solicitacao
import com.br.itau.cliente.api.interactors.strategy.ValidacaoStrategy
import org.springframework.stereotype.Service
import com.br.itau.cliente.api.interactors.mapper.SolicitacaoResponseMapper.Companion.INSTANCE as mapper

@Service
class SolicitacaoCartaoUseCase(private val validacao : ValidacaoStrategy, private val solicitacaoDataSource : SolicitacaoDataSource) {

    fun enviarSolicitacaoCartao(solicitacao: Solicitacao) : Solicitacao {
        validacao.validarSolciitacao(solicitacao)
        return mapper.toEntity(solicitacaoDataSource.enviarSolicitacao(solicitacao))
    }
}