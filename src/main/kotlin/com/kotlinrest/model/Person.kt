package com.kotlinrest.model

import com.kotlinrest.enums.Gender
import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: Gender = Gender.MALE,
    var age: Int = 0
)