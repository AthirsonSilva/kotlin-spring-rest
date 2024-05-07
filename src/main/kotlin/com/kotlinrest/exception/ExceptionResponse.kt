package com.kotlinrest.exception

data class ExceptionResponse(
    val timestamp: String,
    val message: String?,
    val details: String
)
