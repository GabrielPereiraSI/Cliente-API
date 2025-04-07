package com.br.itau.cliente.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ClienteApiApplication

fun main(args: Array<String>) {
	runApplication<ClienteApiApplication>(*args)
}
