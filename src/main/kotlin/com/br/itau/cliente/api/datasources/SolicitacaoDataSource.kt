package com.br.itau.cliente.api.datasources

import com.br.itau.cliente.api.datasources.http.SolicitacaoFeingClient
import com.br.itau.cliente.api.entities.Solicitacao
import com.br.itau.cliente.api.transportlayers.request.SolicitacaoRequest
import org.springframework.stereotype.Service

@Service
interface SolicitacaoDataSource{

    val solicitacaoFeingClient : SolicitacaoFeingClient

    fun enviarSolicitacao(solicitacao : Solicitacao){
        solicitacaoFeingClient.enviarSolicitacao(SolicitacaoRequest("","",0,"","",0.00,"",""))
    }
}