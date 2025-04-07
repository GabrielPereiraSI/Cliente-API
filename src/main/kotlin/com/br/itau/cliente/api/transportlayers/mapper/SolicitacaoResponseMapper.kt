package com.br.itau.cliente.api.transportlayers.mapper

import com.br.itau.cliente.api.entities.Solicitacao
import com.br.itau.cliente.api.transportlayers.response.SolicitacaoResponse
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface SolicitacaoResponseMapper {
    companion object {
        val INSTANCE: SolicitacaoResponseMapper = Mappers.getMapper(SolicitacaoResponseMapper::class.java)
    }

    fun toEntity(request: SolicitacaoResponse): Solicitacao
    fun toResponse(model: Solicitacao): SolicitacaoResponse
}