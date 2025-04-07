package com.br.itau.cliente.api.configs.exceptions

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ValidacaoHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String?>> {
        val errors = ex.bindingResult.fieldErrors.associate { it.field to it.defaultMessage }
        return ResponseEntity(errors, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(ex: ConstraintViolationException): ResponseEntity<Map<String, Any>> {
        val errors = ex.constraintViolations.associate {
            it.propertyPath.toString() to it.message
        }
        return ResponseEntity(mapOf("errors" to errors), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadable(ex: HttpMessageNotReadableException): ResponseEntity<Map<String, String>> {
        return ResponseEntity(mapOf("error" to "Requisição inválida: JSON malformado"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<Map<String, String>> {
        val errorMessage = mapOf("error" to (ex.message ?: "Erro interno do servidor"))
        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ValidacaoFlagException::class)
    fun handleFlagException(ex: ValidacaoFlagException): ResponseEntity<Map<String, String>> {
        return ResponseEntity( mapOf("error" to (ex.message ?: "Erro de negocio flag")), HttpStatus.UNPROCESSABLE_ENTITY)
    }
}