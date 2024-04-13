package com.kotlinrest.service

import org.springframework.stereotype.Service

@Service
class MathService {

    fun sum(num1: Int?, num2: Int?): Int {
        if (num1 == null || num2 == null || num1 < 0 || num2 < 0)
            throw UnsupportedOperationException("Parameters 'num1' and 'num2' must not be null")
        return num1 + num2
    }

    fun sub(num1: Int?, num2: Int?): Int {
        if (num1 == null || num2 == null || num1 < 0 || num2 < 0)
            throw UnsupportedOperationException("Parameters 'num1' and 'num2' must not be null")

        return num1 - num2
    }

    fun mult(num1: Int?, num2: Int?): Int {
        if (num1 == null || num2 == null || num1 < 0 || num2 < 0)
            throw UnsupportedOperationException("Parameters 'num1' and 'num2' must not be null")

        return num1 * num2
    }

    fun div(num1: Int?, num2: Int?): Int {
        if (num1 == null || num2 == null || num1 < 0 || num2 < 0)
            throw UnsupportedOperationException("Parameters 'num1' and 'num2' must not be null")

        return num1 / num2
    }

    fun mean(num1: Int?, num2: Int?): Double {
        if (num1 == null || num2 == null || num1 < 0 || num2 < 0)
            throw UnsupportedOperationException("Parameters 'num1' and 'num2' must not be null")

        return (num1 + num2) / 2.0
    }

    fun square(num: Int): Int {
        if (num < 0)
            throw UnsupportedOperationException("Parameter 'num' must not be less than 0")

        return num * num
    }

}