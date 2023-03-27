package com.example.kt1.infrastructure.adapters.input.rest.data.response

import java.time.LocalDateTime

class EquipmentQueryResponse {
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    var createdAt: LocalDateTime? = null
    var createBy: String? = null
    var updatedAt: LocalDateTime? = null
    var updatedBy: String? = null
}