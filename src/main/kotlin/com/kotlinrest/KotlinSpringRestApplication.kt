package com.kotlinrest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringRestApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringRestApplication>(*args)
}
