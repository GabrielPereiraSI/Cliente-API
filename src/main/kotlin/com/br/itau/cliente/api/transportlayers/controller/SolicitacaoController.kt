package com.br.itau.cliente.api.transportlayers.controller

import com.br.itau.cliente.api.interactors.SolicitacaoCartaoUseCase
import com.br.itau.cliente.api.transportlayers.request.SolicitacaoRequest
import com.br.itau.cliente.api.transportlayers.response.SolicitacaoResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.br.itau.cliente.api.transportlayers.mapper.SolicitacaoMapper.Companion.INSTANCE as mapperRequest
import com.br.itau.cliente.api.transportlayers.mapper.SolicitacaoResponseMapper.Companion.INSTANCE as mapperResponse

@RestController
class SolicitacaoController(
    private val solicitacaoCartaoUseCase: SolicitacaoCartaoUseCase) {

    @PostMapping("/cartoes")
    @Operation(summary = "Cria uma nova solicitação de cartão", description = "Valida e retorna os cartões ofertados ao cliente")
    @ApiResponse(responseCode = "200", description = "Solicitação aceita, cartão aprovado")
    @ApiResponse(responseCode = "204", description = "Nenhum cartão disponível para o cliente")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "422", description = "Regras de negócio não atendidas")
    fun solicitarCartao(@RequestBody solicitacaoRequest: SolicitacaoRequest): ResponseEntity<SolicitacaoResponse> {
        return solicitacaoCartaoUseCase
            .enviarSolicitacaoCartao(mapperRequest.toEntity(solicitacaoRequest))
            .takeIf { resultado -> resultado != null }
            ?.let { resultado -> ResponseEntity.ok(mapperResponse.toResponse(resultado)) }
            ?: ResponseEntity.noContent().build()
    }

}