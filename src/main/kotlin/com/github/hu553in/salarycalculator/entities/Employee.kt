package com.github.hu553in.salarycalculator.entities

import com.fasterxml.jackson.databind.node.ObjectNode

data class Employee(
        val id: String,
        val type: String,
        val firstName: String,
        val lastName: String,
        val patronymic: String?,
        val workStartDate: String,
        val salary: Int?,
        val additionalInfo: ObjectNode?
)
