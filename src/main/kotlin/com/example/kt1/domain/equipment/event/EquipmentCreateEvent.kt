package com.example.kt1.domain.equipment.event

import java.time.LocalDateTime
import java.util.UUID

class EquipmentCreateEvent(
    var id: UUID?
) {
    var date: LocalDateTime = LocalDateTime.now()
}