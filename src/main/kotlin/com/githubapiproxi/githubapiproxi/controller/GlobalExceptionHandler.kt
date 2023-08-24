package com.githubapiproxi.githubapiproxi.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(HttpMediaTypeNotAcceptableException::class)
    fun handleHttpMediaTypeNotAcceptableException(ex: HttpMediaTypeNotAcceptableException): ResponseEntity<Map<String, Any>> {
        val body = mapOf("status" to HttpStatus.NOT_ACCEPTABLE.value(), "Message" to "Media type not supported")
        val headers = HttpHeaders()
        headers.set("Content-Type", "application/json")
        return ResponseEntity(body, headers, HttpStatus.NOT_ACCEPTABLE)
    }
}

