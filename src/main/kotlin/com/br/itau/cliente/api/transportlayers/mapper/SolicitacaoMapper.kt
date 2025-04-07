package com.br.itau.cliente.api.transportlayers.mapper

import com.br.itau.cliente.api.entities.Solicitacao
import com.br.itau.cliente.api.transportlayers.request.SolicitacaoRequest
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface SolicitacaoMapper {
    companion object {
        val INSTANCE: SolicitacaoMapper = Mappers.getMapper(SolicitacaoMapper::class.java)
    }

    fun toEntity(request: SolicitacaoRequest): Solicitacao
    fun toRequest(model: Solicitacao): SolicitacaoRequest
}