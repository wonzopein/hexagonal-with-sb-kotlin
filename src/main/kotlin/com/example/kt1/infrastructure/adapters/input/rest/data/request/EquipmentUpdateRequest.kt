package com.example.kt1.infrastructure.adapters.input.rest.data.request

data class EquipmentUpdateRequest(
    var name: String? = null,
    var description: String? = null,
    var updatedBy: String? = null,
    var mode: Int? = null
)