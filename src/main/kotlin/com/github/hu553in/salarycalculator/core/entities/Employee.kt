package com.github.hu553in.salarycalculator.core.entities

data class Employee(
        val id: String,
        val type: String,
        val salaryInfo: EmployeeSalaryInfo
)
