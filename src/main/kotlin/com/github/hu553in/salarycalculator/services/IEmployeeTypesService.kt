package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.entities.EmployeeType
import com.github.hu553in.salarycalculator.exceptions.ServiceException

interface IEmployeeTypesService {
    @Throws(ServiceException::class)
    fun getEmployeeTypes(): List<EmployeeType>

    @Throws(ServiceException::class)
    fun getSalaryFormulaByType(type: String): String?
}
