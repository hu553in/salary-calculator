package com.github.hu553in.salarycalculator.core.entities

data class EmployeeSalaryInfo(
        val formula: String,
        val variables: Map<String, Double>
)
