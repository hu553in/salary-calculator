package com.github.hu553in.salarycalculator.core.exceptions

class RepositoryException : Exception {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}
