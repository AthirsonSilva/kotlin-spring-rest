package com.kotlinrest.service

import com.kotlinrest.exception.ResourceNotFoundException
import com.kotlinrest.model.Person
import com.kotlinrest.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepository: PersonRepository
) {
    private val logger = LoggerFactory.getLogger(PersonService::class.java)

    fun create(person: Person): Person {
        logger.info("Creating person: $person")
        return personRepository.save(person)
    }

    fun updateById(id: Long, person: Person): Person {
        logger.info("Updating person: $id $person")
        val foundPerson = findPersonById(id)
        foundPerson.firstName = person.firstName
        foundPerson.lastName = person.lastName
        foundPerson.address = person.address
        foundPerson.age = person.age
        foundPerson.gender = person.gender
        return personRepository.save(foundPerson)
    }

    fun deleteById(id: Long) {
        logger.info("Deleting person by id: $id")
        personRepository.deleteById(id)
    }

    fun findPersonById(id: Long): Person {
        logger.info("Finding person by id: $id")
        return personRepository.findById(id).orElseThrow {
            ResourceNotFoundException("Person with id $id not found")
        }
    }

    fun findAllPersons(): List<Person> {
        logger.info("Finding all persons")
        return personRepository.findAll()
    }

}