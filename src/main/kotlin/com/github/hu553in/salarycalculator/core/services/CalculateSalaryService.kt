package com.github.hu553in.salarycalculator.core.services

import com.github.hu553in.salarycalculator.core.exceptions.ServiceException
import com.github.hu553in.salarycalculator.core.repositories.IEmployeeRepository
import net.objecthunter.exp4j.ExpressionBuilder

class CalculateSalaryService(private val employeeRepository: IEmployeeRepository) : ICalculateSalaryService {
    override fun calculate(employeeId: String): Double = try {
        val employee = employeeRepository.getById(employeeId)
        val expression = ExpressionBuilder(employee.salaryInfo.formula)
                .variables(employee.salaryInfo.variables.keys)
                .build()
                .apply {
                    employee.salaryInfo.variables.forEach {
                        setVariable(it.key, it.value)
                    }
                }
        expression.evaluate()
    } catch (t: Throwable) {
        throw ServiceException("Unable to calculate salary because of: ${t.message}", t)
    }
}
