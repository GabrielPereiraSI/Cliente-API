package com.br.itau.cliente.api.datasources.http

import com.br.itau.cliente.api.transportlayers.request.SolicitacaoRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "solicitacao-service", url = "http://localhost:8081")
interface SolicitacaoFeingClient {

    @PostMapping("/solicitacoes")
    fun enviarSolicitacao(solicitacao: SolicitacaoRequest): ResponseEntity<Any>
}