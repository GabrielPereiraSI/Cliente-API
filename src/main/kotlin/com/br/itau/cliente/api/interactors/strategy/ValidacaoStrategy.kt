package com.br.itau.cliente.api.interactors.strategy

import com.br.itau.cliente.api.entities.Solicitacao

interface ValidacaoStrategy {

    fun validarSolciitacao(solicitacao: Solicitacao)
}