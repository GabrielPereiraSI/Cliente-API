package com.br.itau.cliente.api.interactors.mapper

import com.br.itau.cliente.api.datasources.dto.SolicitacaoResponse
import com.br.itau.cliente.api.entities.Solicitacao
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.springframework.http.ResponseEntity

@Mapper
interface SolicitacaoResponseMapper {
    companion object {
        val INSTANCE: SolicitacaoResponseMapper = Mappers.getMapper(SolicitacaoResponseMapper::class.java)
    }
    fun toEntity(request: ResponseEntity<SolicitacaoResponse>): Solicitacao
    fun toRequest(entity: Solicitacao): SolicitacaoResponse
}