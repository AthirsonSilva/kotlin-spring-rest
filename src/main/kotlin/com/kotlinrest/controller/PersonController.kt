package com.kotlinrest.controller

import com.kotlinrest.data.dto.v1.PersonDto
import com.kotlinrest.service.PersonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/PersonDto")
@Tag(name = "PersonDto Controller", description = "PersonDto operations")
class PersonController(
    private var personService: PersonService
) {

    @GetMapping("/{id}")
    @Operation(summary = "Get a PersonDto", description = "Get a PersonDto by ID")
    fun getPerson(@PathVariable id: Long): ResponseEntity<PersonDto> {
        return ResponseEntity(personService.findPersonById(id), HttpStatus.OK)
    }

    @GetMapping()
    @Operation(summary = "Get all persons", description = "Get all persons")
    fun getPeople(): ResponseEntity<List<PersonDto>> {
        return ResponseEntity(personService.findAllPersons(), HttpStatus.OK)
    }

    @PostMapping
    @Operation(summary = "Create a PersonDto", description = "Create a PersonDto")
    fun createPerson(personDto: PersonDto): ResponseEntity<PersonDto> {
        return ResponseEntity(personService.create(personDto), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a PersonDto", description = "Update a PersonDto")
    fun updatePerson(@PathVariable id: Long, @RequestBody personDto: PersonDto): ResponseEntity<PersonDto> {
        return ResponseEntity(personService.updateById(id, personDto), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a PersonDto", description = "Delete a PersonDto")
    fun deletePerson(@PathVariable id: Long): ResponseEntity<Void> {
        personService.deleteById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}