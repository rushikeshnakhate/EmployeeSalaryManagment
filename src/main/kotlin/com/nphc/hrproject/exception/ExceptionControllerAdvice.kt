package com.nphc.hrproject.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice : ResponseEntityExceptionHandler() {

}
