package com.br.itau.cliente.api.interactors.mapper

import com.br.itau.cliente.api.datasources.dto.SolicitacaoRequest
import com.br.itau.cliente.api.entities.Solicitacao
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface SolicitacaoRequestMapper {
    companion object {
        val INSTANCE: SolicitacaoRequestMapper = Mappers.getMapper(SolicitacaoRequestMapper::class.java)
    }
    fun toEntity(request: SolicitacaoRequest): Solicitacao
    fun toRequest(entity: Solicitacao): SolicitacaoRequest
}