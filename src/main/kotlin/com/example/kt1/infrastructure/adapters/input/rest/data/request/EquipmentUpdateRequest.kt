package com.example.kt1.infrastructure.adapters.input.rest.data.request

import com.example.kt1.domain.model.EquipmentMode

data class EquipmentUpdateRequest(
    var name: String? = null,
    var description: String? = null,
    var updatedBy: String? = null,
    var mode: Int = EquipmentMode.UNKNOWN.code
)