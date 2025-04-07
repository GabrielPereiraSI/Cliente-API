package com.br.itau.cliente.api.datasources.dto

data class SolicitacaoResponse(
    val nome: String,
    val cpf: String,
    val idade: Int,
    val data_nascimento: String,
    val uf: String,
    val renda_mensal: Double,
    val email: String,
    val telefone_whatsapp: String)
