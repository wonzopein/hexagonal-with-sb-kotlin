package com.example.kt1.infrastructure.adapters.input.event

import com.example.kt1.domain.equipment.event.EquipmentCreateEvent
import com.example.kt1.domain.equipment.event.EquipmentUpdateEvent
import com.example.kt1.infrastructure.adapters.configuration.logger
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class EquipmentEventListenerAdapter {

    private val log = logger()
    @EventListener
    fun equipmentCreateEventHandler(equipmentCreateEvent: EquipmentCreateEvent){
        log.info("Equipment created with id " + equipmentCreateEvent.id + " at " + equipmentCreateEvent.date)
    }

    @EventListener
    fun equipmentUpdateEventHandler(equipmentUpdateEvent: EquipmentUpdateEvent){
        log.info("Equipment updated with id " + equipmentUpdateEvent.id + " at " + equipmentUpdateEvent.date)
    }
}