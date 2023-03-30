package com.example.kt1.infrastructure.adapters.output.customizedexception

import java.time.LocalDateTime

class ExceptionResponse(
    var date: LocalDateTime,
    var message: String?,
    var details: List<String>
)