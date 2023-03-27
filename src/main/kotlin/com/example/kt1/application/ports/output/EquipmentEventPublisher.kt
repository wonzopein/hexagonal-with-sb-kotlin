package com.example.kt1.application.ports.output

import com.example.kt1.domain.event.EquipmentCreateEvent

interface EquipmentEventPublisher {
    fun publishEquipmentCreateEvent(event: EquipmentCreateEvent)
}