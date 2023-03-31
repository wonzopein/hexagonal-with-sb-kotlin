package com.example.kt1.domain.event

import java.time.LocalDateTime
import java.util.UUID

class EquipmentCreateEvent(
    private var id: UUID?
) {
    private var date: LocalDateTime = LocalDateTime.now()
}