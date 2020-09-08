package com.github.hu553in.salarycalculator.core.repositories

import com.github.hu553in.salarycalculator.core.entities.Employee
import com.github.hu553in.salarycalculator.core.exceptions.RepositoryException
import org.springframework.stereotype.Repository

@Repository
interface IEmployeeRepository {
    @Throws(RepositoryException::class)
    fun getById(id: String): Employee
}
