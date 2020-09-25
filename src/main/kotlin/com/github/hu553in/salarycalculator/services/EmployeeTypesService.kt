package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.entities.EmployeeType
import com.github.hu553in.salarycalculator.exceptions.ServiceException
import org.springframework.stereotype.Service

@Service
class EmployeeTypesService(private val employeeTypes: List<EmployeeType>) : IEmployeeTypesService {
    @Throws(ServiceException::class)
    override fun getEmployeeTypes(): List<EmployeeType> = employeeTypes

    @Throws(ServiceException::class)
    override fun getSalaryFormulaByType(type: String) =
            employeeTypes.firstOrNull { it.type == type }?.salaryFormula
}
