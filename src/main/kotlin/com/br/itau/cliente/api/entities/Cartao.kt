package com.br.itau.cliente.api.entities

data class Cartao(
    val tipoCartao: String,
    val valorAnuidadeMensal: Double,
    val valorLimiteDisponivel: Double,
    val status: String)
