package com.github.hu553in.salarycalculator.entities

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.node.ObjectNode

data class Employee(
        val id: String,
        val type: String,
        @JsonProperty("first_name") val firstName: String,
        @JsonProperty("last_name") val lastName: String,
        val patronymic: String?,
        @JsonProperty("work_start_date") val workStartDate: String,
        val salary: Int?,
        @JsonProperty("additional_info") val additionalInfo: ObjectNode?
)
