package com.example.kt1.domain.event

import java.time.LocalDateTime

class EquipmentCreateEvent(
        private var id: Long?
) {
    private var date: LocalDateTime = LocalDateTime.now()
}