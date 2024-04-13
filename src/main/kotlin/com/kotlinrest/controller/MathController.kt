package com.kotlinrest.controller

import com.kotlinrest.service.MathService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Math Controller", description = "Math operations")
class MathController(
    private val mathService: MathService
) {

    @GetMapping("/sum/{num1}/{num2}")
    @Operation(summary = "Sum two numbers")
    fun sum(@PathVariable("num1") num1: Int?, @PathVariable("num2") num2: Int?): ResponseEntity<Int> {
        return ResponseEntity.ok(mathService.sum(num1!!, num2!!))
    }

    @GetMapping("/sub/{num1}/{num2}")
    @Operation(summary = "Subtract two numbers")
    fun sub(@PathVariable("num1") num1: Int?, @PathVariable("num2") num2: Int?): ResponseEntity<Int> {
        return ResponseEntity.ok(mathService.sub(num1!!, num2!!))
    }

    @GetMapping("/mult/{num1}/{num2}")
    @Operation(summary = "Multiply two numbers")
    fun mult(@PathVariable("num1") num1: Int?, @PathVariable("num2") num2: Int?): ResponseEntity<Int> {
        return ResponseEntity.ok(mathService.mult(num1!!, num2!!))
    }

    @GetMapping("/div/{num1}/{num2}")
    @Operation(summary = "Divide two numbers")
    fun div(@PathVariable("num1") num1: Int?, @PathVariable("num2") num2: Int?): ResponseEntity<Int> {
        return ResponseEntity.ok(mathService.div(num1!!, num2!!))
    }

    @GetMapping("/mean/{num1}/{num2}")
    @Operation(summary = "Mean of two numbers")
    fun mean(@PathVariable("num1") num1: Int?, @PathVariable("num2") num2: Int?): ResponseEntity<Double> {
        return ResponseEntity.ok(mathService.mean(num1!!, num2!!))
    }

    @GetMapping("/square/{num}")
    @Operation(summary = "Square a number")
    fun square(@PathVariable("num") num: Int?): ResponseEntity<Int> {
        return ResponseEntity.ok(mathService.square(num!!))
    }

}