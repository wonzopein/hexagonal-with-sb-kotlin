package com.example.kt1.application.ports.output

import com.example.kt1.domain.equipment.event.EquipmentCreateEvent
import com.example.kt1.domain.equipment.event.EquipmentUpdateEvent

interface EquipmentEventPublisher {
    fun publishEquipmentCreateEvent(event: EquipmentCreateEvent)
    fun publishEquipmentUpdateEvent(event: EquipmentUpdateEvent)
}