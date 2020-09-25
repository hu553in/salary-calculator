package com.github.hu553in.salarycalculator.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import com.github.hu553in.salarycalculator.entities.Employee
import com.github.hu553in.salarycalculator.exceptions.ServiceException
import com.github.hu553in.salarycalculator.repositories.IEmployeeRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.Period

internal class CalculateSalaryServiceTest {
    private lateinit var employeeRepository: IEmployeeRepository
    private lateinit var employeeTypesService: IEmployeeTypesService
    private lateinit var employee: Employee
    private lateinit var additionalInfo: ObjectNode
    private lateinit var objectMapper: ObjectMapper
    private lateinit var calculateSalaryService: ICalculateSalaryService

    @Before
    fun setUp() {
        employeeRepository = mockk()
        employeeTypesService = mockk()
        employee = mockk()
        additionalInfo = mockk()
        objectMapper = ObjectMapper()
        calculateSalaryService = CalculateSalaryService(employeeRepository, employeeTypesService)
    }

    @Test
    fun shouldReturnSalary() {
        every { employeeRepository.getById("#1") } returns employee
        every { employee.type } returns "worker"
        every {
            employeeTypesService.getSalaryFormulaByType("worker")
        } returns "years_of_work + base_salary + monthly_completed_details + monthly_completed_transactions"
        every { employee.workStartDate } returns "2015-01-01"
        every { employee.additionalInfo } returns additionalInfo
        every { additionalInfo.get("base_salary") } returns objectMapper.readTree("35000")
        every { additionalInfo.get("monthly_completed_details") } returns objectMapper.readTree("100")
        every { additionalInfo.get("monthly_completed_transactions") } returns objectMapper.readTree("200")
        val expected = 35000 + 100 + 200 + Period.between(
                LocalDate.parse("2015-01-01"),
                LocalDate.now()
        ).toTotalMonths() / 12.0
        assertEquals(expected, calculateSalaryService.calculate("#1"), 0.00)
    }

    @Test(expected = ServiceException::class)
    fun shouldRaiseUnableToGetEmployeeByIdError() {
        every { employeeRepository.getById("#1") } returns null
        calculateSalaryService.calculate("#1")
    }

    @Test(expected = ServiceException::class)
    fun shouldRaiseUnableToFindSalaryFormulaByEmployeeTypeError() {
        every { employeeRepository.getById("#1") } returns employee
        every { employee.type } returns "worker"
        every { employeeTypesService.getSalaryFormulaByType("worker") } returns null
        calculateSalaryService.calculate("#1")
    }

    @Test(expected = ServiceException::class)
    fun shouldRaiseVariableValueIsNotNumberError() {
        every { employeeRepository.getById("#1") } returns employee
        every { employee.type } returns "worker"
        every {
            employeeTypesService.getSalaryFormulaByType("worker")
        } returns "years_of_work + base_salary + monthly_completed_details + monthly_completed_transactions"
        every { employee.workStartDate } returns "2015-01-01"
        every { employee.additionalInfo } returns additionalInfo
        every { additionalInfo.get("base_salary") } returns null
        calculateSalaryService.calculate("#1")
    }
}
