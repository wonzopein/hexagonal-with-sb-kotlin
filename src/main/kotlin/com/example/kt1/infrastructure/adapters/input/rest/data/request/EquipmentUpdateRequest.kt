package com.example.kt1.infrastructure.adapters.input.rest.data.request

import com.example.kt1.domain.equipment.model.EquipmentMode
import java.util.*

class EquipmentUpdateRequest {
    var id: UUID? = null
    var name: String? = null
    var description: String? = null
    var updatedBy: String? = null
    var mode: Int = EquipmentMode.UNKNOWN.code
}