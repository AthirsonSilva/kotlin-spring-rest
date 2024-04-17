package com.kotlinrest.service

import com.kotlinrest.data.dto.v1.PersonDto
import com.kotlinrest.exception.ResourceNotFoundException
import com.kotlinrest.mapper.DozerMapper
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
        val personToCreate = DozerMapper.map(person, Person::class.java)
        return DozerMapper.map(personRepository.save(personToCreate), PersonDto::class.java)
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

        return DozerMapper.map(personRepository.save(foundPerson), PersonDto::class.java)
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
        return DozerMapper.map(person, PersonDto::class.java)
    }

    fun findAllPersons(): List<PersonDto> {
        logger.info("Finding all persons")
        return DozerMapper.mapList(personRepository.findAll(), PersonDto::class.java)
    }

}