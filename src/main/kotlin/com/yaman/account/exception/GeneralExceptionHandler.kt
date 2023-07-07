package com.yaman.account.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GeneralExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException::class)
    fun customerNotFoundExceptionHandler(exception: CustomerNotFoundException): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.NOT_FOUND)
    }



}