package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.exceptions.ServiceException

interface ICalculateSalaryService {
    @Throws(ServiceException::class)
    fun calculate(employeeId: String): Double
}
