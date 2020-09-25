package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.exceptions.ServiceException
import com.github.hu553in.salarycalculator.repositories.IEmployeeRepository
import net.objecthunter.exp4j.ExpressionBuilder
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Period

@Service
class CalculateSalaryService(
        private val employeeRepository: IEmployeeRepository,
        private val employeeTypesService: IEmployeeTypesService
) : ICalculateSalaryService {
    private val extractVariableNamesRegex = Regex("[a-zA-Z_]+")

    @Throws(ServiceException::class)
    override fun calculate(employeeId: String): Double = try {
        val employee = employeeRepository.getById(employeeId)
                ?: throw Exception("Unable to get employee by ID '$employeeId")
        val salaryFormula = employeeTypesService.getSalaryFormulaByType(employee.type)
                ?: throw Exception("Unable to find salary formula by employee type '${employee.type}'")
        val variableNames = extractVariableNamesRegex.findAll(salaryFormula).map { it.value }.toSet()
        ExpressionBuilder(salaryFormula).variables(variableNames).build()
                .apply {
                    variableNames.forEach {
                        if (it == "years_of_work") {
                            setVariable(it, Period.between(
                                    LocalDate.parse(employee.workStartDate),
                                    LocalDate.now()
                            ).toTotalMonths() / 12.0)
                        } else {
                            val variableValue = employee.additionalInfo?.get(it)
                            if (variableValue == null || !variableValue.isNumber) {
                                throw Exception(
                                        "Employee variable '$it' value is not number " +
                                                "(value is '$variableValue')"
                                )
                            }
                            setVariable(it, variableValue.asDouble())
                        }
                    }
                }
                .evaluate()
    } catch (t: Throwable) {
        if (t::class is Exception) {
            throw t
        }
        throw ServiceException("Unable to calculate salary because of: ${t.message}", t)
    }
}
