package com.github.hu553in.salarycalculator.core.repositories

import com.github.hu553in.salarycalculator.core.entities.Employee
import com.github.hu553in.salarycalculator.core.entities.EmployeeSalaryInfo

class EmployeeRepository : IEmployeeRepository {
    override fun getById(id: String): Employee = Employee("", "", EmployeeSalaryInfo("", mapOf()))
}
