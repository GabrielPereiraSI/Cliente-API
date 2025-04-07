package com.br.itau.cliente.api.transportlayers.request

import jakarta.validation.constraints.*;

data class SolicitacaoRequest(
        @field:NotBlank
        val nome: String,

        @field:Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                message = "O cliente deve inserir um cpf valido")
        val cpf: String,

        @field:NotBlank(message = "A idade deve ser preenchida")
        val idade: Int,

        @field:Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",
                message = "A data de nascimento deve estar no formato yyyy-MM-dd")
        val data_nascimento: String,

        @field:NotBlank(message = "O cliente deve inserir a UF")
        val uf: String,

        @field:PositiveOrZero(message = "O cliente deve inserir uma renda válida")
        val renda_mensal: Double,

        @field:Email(message = "E-mail inválido")
        val email: String,

        @field:Pattern(regexp = "\\d{11}", message = "O telefone deve ter 11 dígitos")
        val telefone_whatsapp: String)