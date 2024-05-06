package com.kotlinrest

import com.kotlinrest.data.dto.PersonDto
import com.kotlinrest.enums.Gender
import com.kotlinrest.mapper.Dozer
import com.kotlinrest.model.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DozerTest {

    var inputObject: MockPerson? = null

    @BeforeEach
    fun setUp() {
        inputObject = MockPerson()
    }

    @Test
    fun parseEntityToVOTest() {
        val output: PersonDto = Dozer.map(inputObject!!.mockEntity(), PersonDto::class.java)
        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("Address Test0", output.address)
        assertEquals(Gender.MALE, output.gender)
    }

    @Test
    fun parseEntityListToVOListTest() {
        val outputList: List<PersonDto> =
            Dozer.mapList(inputObject!!.mockEntityList(), PersonDto::class.java)

        val outputZero: PersonDto = outputList[0]

        assertEquals("First Name Test0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("Address Test0", outputZero.address)
        assertEquals(Gender.MALE, outputZero.gender)

        val outputSeven: PersonDto = outputList[7]
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("Address Test7", outputSeven.address)
        assertEquals(Gender.FEMALE, outputSeven.gender)

        val outputTwelve: PersonDto = outputList[12]
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("Address Test12", outputTwelve.address)
        assertEquals(Gender.MALE, outputTwelve.gender)
    }

    @Test
    fun parseVOToEntityTest() {

        val output: Person = Dozer.map(inputObject!!.mockVO(), Person::class.java)

        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("Address Test0", output.address)
        assertEquals(Gender.MALE, output.gender)
    }

    @Test
    fun parserVOListToEntityListTest() {

        val outputList: List<Person> = Dozer.mapList(inputObject!!.mockVOList(), Person::class.java)

        val outputZero: Person = outputList[0]
        assertEquals("First Name Test0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("Address Test0", outputZero.address)
        assertEquals(Gender.MALE, outputZero.gender)

        val outputSeven: Person = outputList[7]
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("Address Test7", outputSeven.address)
        assertEquals(Gender.FEMALE, outputSeven.gender)

        val outputTwelve: Person = outputList[12]
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("Address Test12", outputTwelve.address)
        assertEquals(Gender.MALE, outputTwelve.gender)
    }
}