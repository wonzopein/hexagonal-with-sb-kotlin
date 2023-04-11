package com.example.kt1.domain.equipment.event

import java.time.LocalDateTime
import java.util.*

class EquipmentUpdateEvent (
    var id: UUID?
) {
    var date: LocalDateTime = LocalDateTime.now()
}