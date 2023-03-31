package com.example.kt1.infrastructure.adapters.input.rest.data.response

import com.example.kt1.domain.model.EquipmentMode
import java.util.UUID

class EquipmentCreateResponse(
    var id: UUID,
    var name: String,
    var description: String,
    var mode: EquipmentMode
)