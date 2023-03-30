package com.example.kt1.infrastructure.adapters.input.rest.data.response

import com.example.kt1.domain.model.EquipmentMode

class EquipmentCreateResponse(
    var id: Long,
    var name: String,
    var description: String,
    var mode: EquipmentMode
)