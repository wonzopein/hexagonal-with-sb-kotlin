package com.example.kt1.domain.equipment.model

import java.time.LocalDateTime
import java.util.UUID


class Equipment {
    var id: UUID? = null
    var name: String? = null
    var description: String? = null
    var createdAt: LocalDateTime? = null
    var createBy: String? = null
    var updatedAt: LocalDateTime? = null
    var updatedBy: String? = null
    var mode: EquipmentMode = EquipmentMode.UNKNOWN
}