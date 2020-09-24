package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.exceptions.ServiceException
import com.github.hu553in.salarycalculator.entities.EmployeeType
import org.springframework.stereotype.Service

@Service
interface IEmployeeTypesService {
    @Throws(ServiceException::class)
    fun getEmployeeTypes(): List<EmployeeType>

    @Throws(ServiceException::class)
    fun getSalaryFormulaByType(type: String): String?
}
