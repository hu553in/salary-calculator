package com.github.hu553in.salarycalculator.core.exceptions

class ServiceException : Exception {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}
