package com.example.kt1.infrastructure.adapters.output.customizedexception

import java.time.LocalDateTime

class ExceptionResponse(
        private var date: LocalDateTime,
        private var message: String?,
        private var details: List<String>
) {

}