package com.github.hu553in.salarycalculator.services

import com.github.hu553in.salarycalculator.exceptions.ServiceException
import com.github.hu553in.salarycalculator.repositories.IEmployeeRepository
import net.objecthunter.exp4j.ExpressionBuilder
import java.time.LocalDate
import java.time.Period

class CalculateSalaryService(
        private val employeeRepository: IEmployeeRepository,
        private val employeeTypesService: IEmployeeTypesService
) : ICalculateSalaryService {
    private val extractVariableNamesRegex = Regex("\$[a-zA-Z_]")

    override fun calculate(employeeId: String): Double = try {
        val employee = employeeRepository.getById(employeeId)
                ?: throw Exception("Unable to get employee by ID '$employeeId")
        val salaryFormula = employeeTypesService.getSalaryFormulaByType(employee.type)
                ?: throw Exception("Unable to find salary formula by employee type '${employee.type}'")
        val variableNames = extractVariableNamesRegex
                .findAll(salaryFormula)
                .map { it.value.removePrefix("$") }
                .toSet()
        val monthsOfWork = Period.between(LocalDate.parse(employee.workStartDate), LocalDate.now()).toTotalMonths()
        ExpressionBuilder(salaryFormula.replace("$", ""))
                .variables(variableNames)
                .build()
                .apply {
                    variableNames.forEach {
                        when (it) {
                            "months_of_work" -> setVariable(it, monthsOfWork.toDouble())
                            "salary" -> {
                                employee.salary?.let { salary -> setVariable(it, salary.toDouble()) }
                                        ?: throw Exception(
                                                "Salary of employee with ID '$employeeId' is null " +
                                                "but exists in formula"
                                        )

                            }
                            else -> {
                                val variableValue = employee.additionalInfo?.get(it)
                                if (variableValue == null || !variableValue.isDouble) {
                                    throw Exception(
                                            "Employee variable '$it' value is not double " +
                                                    "(value is '$variableValue')"
                                    )
                                }
                                setVariable(it, variableValue.asDouble())
                            }
                        }
                    }
                }
                .evaluate()
    } catch (t: Throwable) {
        throw ServiceException("Unable to calculate salary because of: ${t.message}", t)
    }
}
