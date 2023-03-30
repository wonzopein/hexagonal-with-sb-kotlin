package com.example.kt1.infrastructure.adapters.output.customizedexception.data.response

import com.example.kt1.domain.exception.EquipmentNotFound
import com.example.kt1.infrastructure.adapters.output.customizedexception.ExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.util.*

@RestControllerAdvice
class CustomizedExceptionAdapter : ResponseEntityExceptionHandler() {

//    @ExceptionHandler(Exception::class)
//    fun handleAllExceptions(exception: Exception, request: WebRequest): ResponseEntity<Any> {
//        val exceptionResponse = ExceptionResponse(
//            LocalDateTime.now(),
//            exception.message,
//            listOf(request.getDescription(false))
//        )
//        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
//    }

    @ExceptionHandler(EquipmentNotFound::class)
    fun handlerEquipmentNotFound(equipmentNotFound: EquipmentNotFound, request: WebRequest): ResponseEntity<Any> {
        val exceptionResponse = ExceptionResponse(
            LocalDateTime.now(),
            equipmentNotFound.message,
            listOf(request.getDescription(false))
        )
        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }

//    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatusCode, request: WebRequest): ResponseEntity<Any>? {
//        val errors: MutableList<String> = ArrayList()
//        ex.bindingResult.allErrors.stream().forEach { error: ObjectError -> error.defaultMessage?.let { errors.add(it) } }
//
//        val exceptionResponse = ExceptionResponse(LocalDateTime.now(), "Validation Failed", errors)
//        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
//    }
}