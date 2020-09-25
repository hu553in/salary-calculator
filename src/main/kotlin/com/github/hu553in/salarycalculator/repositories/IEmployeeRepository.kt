package com.github.hu553in.salarycalculator.repositories

import com.github.hu553in.salarycalculator.entities.Employee
import com.github.hu553in.salarycalculator.exceptions.RepositoryException

interface IEmployeeRepository {
    @Throws(RepositoryException::class)
    fun getById(id: String): Employee?
}
