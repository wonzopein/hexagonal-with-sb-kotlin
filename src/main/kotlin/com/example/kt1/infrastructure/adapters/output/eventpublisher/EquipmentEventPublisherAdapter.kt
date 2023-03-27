package com.example.kt1.infrastructure.adapters.output.eventpublisher

import com.example.kt1.application.ports.output.EquipmentEventPublisher
import com.example.kt1.domain.event.EquipmentCreateEvent
import org.springframework.context.ApplicationEventPublisher

class EquipmentEventPublisherAdapter(
        private var applicationEventPublisher: ApplicationEventPublisher
) : EquipmentEventPublisher {

    override fun publishEquipmentCreateEvent(event: EquipmentCreateEvent) {
        applicationEventPublisher.publishEvent(event)
    }

}