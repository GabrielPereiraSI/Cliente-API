package com.br.itau.cliente.api.entities

import java.time.LocalDateTime

data class Solicitacao(
    val numeroSolicitacao: String,
    val dataSolicitacao: LocalDateTime,
    val cliente: Cliente,
    val cartoesOfertados: List<Cartao>)
