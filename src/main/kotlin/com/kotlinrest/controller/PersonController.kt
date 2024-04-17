package com.kotlinrest.controller

import com.kotlinrest.model.Person
import com.kotlinrest.service.PersonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/person")
@Tag(name = "Person Controller", description = "Person operations")
class PersonController(
    private var personService: PersonService
) {

    @GetMapping("/{id}")
    @Operation(summary = "Get a person", description = "Get a person by ID")
    fun getPerson(@PathVariable id: Long): ResponseEntity<Person> {
        return ResponseEntity(personService.findPersonById(id), HttpStatus.OK)
    }

    @GetMapping()
    @Operation(summary = "Get all persons", description = "Get all persons")
    fun getPeople(): ResponseEntity<List<Person>> {
        return ResponseEntity(personService.findAllPersons(), HttpStatus.OK)
    }

    @PostMapping
    @Operation(summary = "Create a person", description = "Create a person")
    fun createPerson(person: Person): ResponseEntity<Person> {
        return ResponseEntity(personService.create(person), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a person", description = "Update a person")
    fun updatePerson(@PathVariable id: Long, @RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(personService.updateById(id, person), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a person", description = "Delete a person")
    fun deletePerson(@PathVariable id: Long): ResponseEntity<Void> {
        personService.deleteById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}