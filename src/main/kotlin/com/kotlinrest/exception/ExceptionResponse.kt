package com.kotlinrest.exception

import java.time.LocalDateTime

data class ExceptionResponse(
    val timestamp: LocalDateTime,
    val message: String?,
    val details: String
)
