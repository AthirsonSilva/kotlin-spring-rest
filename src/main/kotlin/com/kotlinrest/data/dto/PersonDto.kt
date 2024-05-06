package com.kotlinrest.data.dto

import com.kotlinrest.enums.Gender

data class PersonDto(
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: Gender = Gender.MALE,
    var age: Int = 0
)