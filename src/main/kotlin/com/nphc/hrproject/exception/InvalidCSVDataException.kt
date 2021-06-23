package com.nphc.hrproject.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidCSVDataException(message: String) : RuntimeException(message)

