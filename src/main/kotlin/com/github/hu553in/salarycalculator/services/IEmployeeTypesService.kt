package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.entities.EmployeeType

interface IEmployeeTypesService {
    fun getEmployeeTypes(): List<EmployeeType>

    fun getSalaryFormulaByType(type: String): String?
}
