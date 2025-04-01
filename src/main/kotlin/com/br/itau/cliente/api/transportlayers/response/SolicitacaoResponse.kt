package com.br.itau.cliente.api.transportlayers.response

import com.br.itau.cliente.api.entities.Cartao
import com.br.itau.cliente.api.entities.Cliente
import java.time.LocalDateTime

data class SolicitacaoResponse(
    val numeroSolicitacao: String,
    val dataSolicitacao: LocalDateTime,
    val cliente: Cliente,
    val cartoesOfertados: List<Cartao>
)
