package com.br.itau.cliente.api.transportlayers.controller

import com.br.itau.cliente.api.transportlayers.request.SolicitacaoRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SolicitacaoController {

    @PostMapping
    @Operation(summary = "Cria uma nova solicitação de cartão", description = "Valida e retorna os cartões ofertados ao cliente")
    @ApiResponse(responseCode = "200", description = "Solicitação aceita, cartão aprovado")
    @ApiResponse(responseCode = "204", description = "Nenhum cartão disponível para o cliente")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "422", description = "Regras de negócio não atendidas")
    fun solicitarCartao(@RequestBody solicitacao: SolicitacaoRequest): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}