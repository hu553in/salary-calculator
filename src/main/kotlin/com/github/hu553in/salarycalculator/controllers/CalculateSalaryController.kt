package com.github.hu553in.salarycalculator.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hu553in.salarycalculator.models.CommonResponse
import com.github.hu553in.salarycalculator.services.ICalculateSalaryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculateSalaryController(
        private val calculateSalaryService: ICalculateSalaryService,
        private val objectMapper: ObjectMapper
) {
    @GetMapping("/calculate-salary/{id}")
    fun calculateSalary(@PathVariable("id") employeeId: String): ResponseEntity<CommonResponse> = try {
        ResponseEntity(CommonResponse(
                statusCode = HttpStatus.OK.value(),
                data = objectMapper.createObjectNode().apply {
                    this.put("salary", calculateSalaryService.calculate(employeeId))
                }
        ), HttpStatus.OK)
    } catch (t: Throwable) {
        val errors = mutableListOf<String>()
        t.message?.let { errors.add(it) }
        ResponseEntity(CommonResponse(
                statusCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
                errors = errors
        ), HttpStatus.UNPROCESSABLE_ENTITY)
    }
}
