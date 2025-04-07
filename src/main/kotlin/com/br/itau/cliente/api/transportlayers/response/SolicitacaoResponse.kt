package com.br.itau.cliente.api.transportlayers.response

import com.br.itau.cliente.api.entities.Cartao
import com.br.itau.cliente.api.entities.Cliente
import java.time.LocalDateTime

data class SolicitacaoResponse(
    val numero_solicitacao: String,
    val data_solicitacao: LocalDateTime,
    val cliente: Cliente,
    val cartoes_ofertados: List<Cartao>
)
