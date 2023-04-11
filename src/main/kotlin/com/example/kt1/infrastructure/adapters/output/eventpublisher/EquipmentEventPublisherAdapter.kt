package com.example.kt1.infrastructure.adapters.output.eventpublisher

import com.example.kt1.application.ports.output.EquipmentEventPublisher
import com.example.kt1.domain.equipment.event.EquipmentCreateEvent
import com.example.kt1.domain.equipment.event.EquipmentUpdateEvent
import org.springframework.context.ApplicationEventPublisher

class EquipmentEventPublisherAdapter(
    private var applicationEventPublisher: ApplicationEventPublisher
) : EquipmentEventPublisher {

    override fun publishEquipmentCreateEvent(event: EquipmentCreateEvent) {
        applicationEventPublisher.publishEvent(event)
    }

    override fun publishEquipmentUpdateEvent(event: EquipmentUpdateEvent) {
        applicationEventPublisher.publishEvent(event)
    }

}