package com.kotlinrest

import com.kotlinrest.data.dto.v1.PersonDto
import com.kotlinrest.enums.Gender
import com.kotlinrest.model.Person


class MockPerson {
    fun mockEntity(): Person {
        return mockEntity(0)
    }

    fun mockVO(): PersonDto {
        return mockVO(0)
    }

    fun mockEntityList(): ArrayList<Person> {
        val persons: ArrayList<Person> = ArrayList<Person>()
        for (i in 0..13) {
            persons.add(mockEntity(i))
        }
        return persons
    }

    fun mockVOList(): ArrayList<PersonDto> {
        val persons: ArrayList<PersonDto> = ArrayList()
        for (i in 0..13) {
            persons.add(mockVO(i))
        }
        return persons
    }

    fun mockEntity(number: Int): Person {
        val person = Person()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 == 0) Gender.MALE else Gender.FEMALE
        person.lastName = "Last Name Test$number"
        return person
    }

    fun mockVO(number: Int): PersonDto {
        val person = PersonDto()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 == 0) Gender.MALE else Gender.FEMALE
        person.lastName = "Last Name Test$number"
        return person
    }
}