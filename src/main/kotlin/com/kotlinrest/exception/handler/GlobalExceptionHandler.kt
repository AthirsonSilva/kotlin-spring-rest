package com.kotlinrest.exception.handler

import com.kotlinrest.exception.ExceptionResponse
import com.kotlinrest.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        return ResponseEntity<ExceptionResponse>(
            ExceptionResponse(
                timestamp = LocalDateTime.now(),
                message = ex.message,
                details = request.getDescription(false)
            ), HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleGenericResourceNotFoundException(
        ex: ResourceNotFoundException,
        request: WebRequest
    ): ResponseEntity<ExceptionResponse> {
        return ResponseEntity<ExceptionResponse>(
            ExceptionResponse(
                timestamp = LocalDateTime.now(),
                message = ex.message,
                details = request.getDescription(false)
            ), HttpStatus.NOT_FOUND
        )
    }

}