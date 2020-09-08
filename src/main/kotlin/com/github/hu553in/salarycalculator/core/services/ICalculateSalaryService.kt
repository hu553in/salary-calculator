package com.github.hu553in.salarycalculator.core.services

import com.github.hu553in.salarycalculator.core.exceptions.ServiceException
import org.springframework.stereotype.Service

@Service
interface ICalculateSalaryService {
    @Throws(ServiceException::class)
    fun calculate(employeeId: String): Double
}
