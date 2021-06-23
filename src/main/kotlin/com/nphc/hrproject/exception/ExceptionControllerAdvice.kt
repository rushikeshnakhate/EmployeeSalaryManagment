package com.nphc.hrproject.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice : ResponseEntityExceptionHandler() {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors = ex.bindingResult.fieldErrors.map { e -> "${e.field} : ${e.defaultMessage}" }.toList()
        val apiError = ApiError(HttpStatus.BAD_REQUEST, errors)
        return super.handleExceptionInternal(ex, apiError, headers, status, request)
    }

    @ExceptionHandler(InvalidInputException::class)
    fun handleInvalidInput(invalidEmployeeIdException: InvalidInputException): ResponseEntity<String> {
        return ResponseEntity<String>("Invalid input data", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NoSuchFieldException::class)
    fun unexpectedElement(noSuchFieldException: NoSuchFieldException): ResponseEntity<String> {
        return ResponseEntity<String>("Bad Input", HttpStatus.NOT_FOUND)
    }

    data class ApiError(val status: HttpStatus, val error: List<String>)
}
