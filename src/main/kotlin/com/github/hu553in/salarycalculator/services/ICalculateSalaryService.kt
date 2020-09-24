package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.exceptions.ServiceException
import org.springframework.stereotype.Service

@Service
interface ICalculateSalaryService {
    @Throws(ServiceException::class)
    fun calculate(employeeId: String): Double
}
