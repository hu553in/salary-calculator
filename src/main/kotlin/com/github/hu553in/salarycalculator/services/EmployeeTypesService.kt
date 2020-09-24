package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.entities.EmployeeType

class EmployeeTypesService(private val employeeTypes: List<EmployeeType>) : IEmployeeTypesService {
    override fun getEmployeeTypes(): List<EmployeeType> = employeeTypes

    override fun getSalaryFormulaByType(type: String) =
            employeeTypes.firstOrNull { it.type == type }?.salaryFormula
}
