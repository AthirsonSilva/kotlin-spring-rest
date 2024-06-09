package com.kotlinrest.controller

import com.kotlinrest.annotations.RateLimited
import com.kotlinrest.data.dto.PersonDto
import com.kotlinrest.service.PersonService
import com.kotlinrest.util.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
    path = ["/api/v1/person"],
    produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML]
)
@Tag(name = "Person Controller", description = "Person operations")
class PersonController(
    private var personService: PersonService
) {

    @GetMapping("/{id}")
    @RateLimited
    @Operation(summary = "Get a person", description = "Get a person by ID")
    fun getPerson(@PathVariable id: Long): ResponseEntity<PersonDto> {
        return ResponseEntity(personService.findPersonById(id), HttpStatus.OK)
    }

    @GetMapping
    @RateLimited
    @Operation(summary = "Get all persons", description = "Get all persons")
    fun getPeople(): ResponseEntity<List<PersonDto>> {
        return ResponseEntity(personService.findAllPersons(), HttpStatus.OK)
    }

    @PostMapping
    @Operation(summary = "Create a person", description = "Create a person")
    fun createPerson(personDto: PersonDto): ResponseEntity<PersonDto> {
        return ResponseEntity(personService.create(personDto), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a person", description = "Update a person")
    fun updatePerson(@PathVariable id: Long, @RequestBody personDto: PersonDto): ResponseEntity<PersonDto> {
        return ResponseEntity(personService.updateById(id, personDto), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a person", description = "Delete a person")
    fun deletePerson(@PathVariable id: Long): ResponseEntity<Void> {
        personService.deleteById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}