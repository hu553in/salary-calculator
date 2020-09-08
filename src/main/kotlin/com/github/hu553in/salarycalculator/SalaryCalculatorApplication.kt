package com.github.hu553in.salarycalculator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SalaryCalculatorApplication

fun main(args: Array<String>) {
	runApplication<SalaryCalculatorApplication>(*args)
}
