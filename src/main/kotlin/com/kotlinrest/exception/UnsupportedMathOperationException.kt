package com.kotlinrest.exception

data class UnsupportedMathOperationException(val exception: String) : RuntimeException(exception)