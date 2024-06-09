package com.kotlinrest.service

import com.kotlinrest.data.dto.PersonDto
import com.kotlinrest.exception.ResourceNotFoundException
import com.kotlinrest.mapper.Dozer
import com.kotlinrest.model.Person
import com.kotlinrest.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: PersonRepository,
) {
    private val logger = LoggerFactory.getLogger(PersonService::class.java)

    fun create(person: PersonDto): PersonDto {
        logger.info("Creating person: $person")
        val personToCreate = Dozer.map(person, Person::class.java)
        return Dozer.map(personRepository.save(personToCreate), PersonDto::class.java)
    }

    fun updateById(id: Long, person: PersonDto): PersonDto {
        logger.info("Updating person: $id $person")
        val foundPerson = personRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Person with id $id not found")
        }

        foundPerson.firstName = person.firstName
        foundPerson.lastName = person.lastName
        foundPerson.address = person.address
        foundPerson.age = person.age
        foundPerson.gender = person.gender

        return Dozer.map(personRepository.save(foundPerson), PersonDto::class.java)
    }

    fun deleteById(id: Long) {
        logger.info("Deleting person by id: $id")
        personRepository.deleteById(id)
    }

    fun findPersonById(id: Long): PersonDto {
        logger.info("Finding person by id: $id")
        val person = personRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Person with id $id not found")
        }

        return Dozer.map(person, PersonDto::class.java)
    }

    fun findAllPersons(): List<PersonDto> {
        logger.info("Finding all persons")
        return Dozer.mapList(personRepository.findAll(), PersonDto::class.java)
    }

}