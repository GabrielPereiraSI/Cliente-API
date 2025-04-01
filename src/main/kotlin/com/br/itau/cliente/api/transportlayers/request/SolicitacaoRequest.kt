package com.br.itau.cliente.api.transportlayers.request

import jakarta.validation.constraints.*;

data class SolicitacaoRequest(
        @field:NotBlank
        val nome: String,

        @field:Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
        val cpf: String,

        @field:NotBlank
        val idade: Int,

        @field:NotBlank
        val dataNascimento: String,

        @field:NotBlank
        val uf: String,

        @field:NotBlank
        val rendaMensal: Double,

        @field:Email(message = "E-mail inválido")
        val email: String,

        @field:Pattern(regexp = "\\d{11}", message = "O telefone deve ter 11 dígitos")
        val telefoneWhatsapp: String)