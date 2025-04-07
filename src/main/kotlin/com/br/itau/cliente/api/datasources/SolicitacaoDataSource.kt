package com.br.itau.cliente.api.datasources

import com.br.itau.cliente.api.datasources.dto.SolicitacaoResponse
import com.br.itau.cliente.api.datasources.http.SolicitacaoFeingClient
import com.br.itau.cliente.api.entities.Solicitacao
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import com.br.itau.cliente.api.interactors.mapper.SolicitacaoRequestMapper.Companion.INSTANCE as mapper

@Service
class SolicitacaoDataSource(private val solicitacaoFeingClient : SolicitacaoFeingClient){

    fun enviarSolicitacao(solicitacao : Solicitacao): ResponseEntity<SolicitacaoResponse> {
        return solicitacaoFeingClient.enviarSolicitacao(mapper.toRequest(solicitacao))
    }
}