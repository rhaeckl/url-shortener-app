package com.dkbcodefactory.urlshortener.controlleradvice

import com.dkbcodefactory.urlshortener.exception.InvalidUrlException
import com.dkbcodefactory.urlshortener.model.ErrorMessageModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleInvalidUrlException(e: InvalidUrlException): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(
            HttpStatus.BAD_REQUEST.value(),
            e.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}