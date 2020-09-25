package com.github.hu553in.salarycalculator.repositories

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hu553in.salarycalculator.entities.Employee
import com.github.hu553in.salarycalculator.exceptions.RepositoryException
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository(
        private val jdbcOperations: JdbcOperations,
        private val objectMapper: ObjectMapper
) : IEmployeeRepository {
    @Throws(RepositoryException::class)
    override fun getById(id: String): Employee? = try {
        val query = "SELECT document FROM employees WHERE document->>'id' = ?"
        jdbcOperations.query(query, arrayOf(id)) { rs, _ ->
            objectMapper.readValue<Employee>(rs.getString("document"), Employee::class.java)
        }.singleOrNull()
    } catch (e: Exception) {
        throw RepositoryException("Unable to get employee by ID because of: ${e.message}", e)
    }
}
