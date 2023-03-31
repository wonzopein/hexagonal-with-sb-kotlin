package com.example.kt1.infrastructure.adapters.input.rest.data.response

import com.example.kt1.domain.model.EquipmentMode
import java.time.LocalDateTime
import java.util.UUID

class EquipmentUpdateResponse {
    var id: UUID? = null
    var name: String? = null
    var description: String? = null
    var createdAt: LocalDateTime? = null
    var createBy: String? = null
    var updatedAt: LocalDateTime? = null
    var updatedBy: String? = null
    var mode: EquipmentMode = EquipmentMode.UNKNOWN
}