package com.br.itau.cliente.api.interactors

import com.br.itau.cliente.api.datasources.SolicitacaoDataSource
import com.br.itau.cliente.api.entities.Solicitacao
import com.br.itau.cliente.api.interactors.strategy.ValidacaoStrategy


class SolicitacaoCartaoUseCase(private val validacao : ValidacaoStrategy, private val solicitacaoDataSource : SolicitacaoDataSource) {

    fun enviarSolicitacaoCartao(solicitacao: Solicitacao){
        validacao.validarSolciitacao(solicitacao)
        solicitacaoDataSource.enviarSolicitacao(solicitacao)
    }
}