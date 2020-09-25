package com.github.hu553in.salarycalculator.configurations

import com.github.hu553in.salarycalculator.entities.EmployeeType
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "employee-types")
class EmployeeTypesConfiguration {
    val types: List<EmployeeType> = mutableListOf()

    @Bean
    fun employeeTypes() = types
}
