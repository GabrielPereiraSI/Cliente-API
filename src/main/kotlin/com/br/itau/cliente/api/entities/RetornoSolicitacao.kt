package com.br.itau.cliente.api.entities

import java.time.LocalDateTime

class RetornoSolicitacao(
    val numero_solicitacao: String,
    val data_solicitacao: LocalDateTime,
    val cliente: Cliente,
    val cartoes_ofertados: List<Cartao>)