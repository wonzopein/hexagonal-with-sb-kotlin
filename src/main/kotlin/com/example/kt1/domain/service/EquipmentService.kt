package com.example.kt1.domain.service

import com.example.kt1.application.ports.input.CreateEquipmentUserCase
import com.example.kt1.application.ports.input.GetEquipmentUseCase
import com.example.kt1.application.ports.input.UpdateEquipmentUseCase
import com.example.kt1.application.ports.output.EquipmentEventPublisher
import com.example.kt1.application.ports.output.EquipmentOutputPort
import com.example.kt1.domain.event.EquipmentCreateEvent
import com.example.kt1.domain.exception.EquipmentNotFound
import com.example.kt1.domain.model.Equipment
import java.util.UUID

class EquipmentService(
    private var equipmentOutputPort: EquipmentOutputPort,
    private var equipmentEventPublisher: EquipmentEventPublisher
) : CreateEquipmentUserCase, UpdateEquipmentUseCase, GetEquipmentUseCase {

    override fun createEquipment(equipment: Equipment): Equipment {
        val persistenceEquipment = equipmentOutputPort.createEquipment(equipment)
        equipmentEventPublisher.publishEquipmentCreateEvent(EquipmentCreateEvent(persistenceEquipment.id))
        return persistenceEquipment
    }

    override fun getEquipmentById(id: UUID): Equipment {
        return equipmentOutputPort.getEquipmentById(id) ?: throw EquipmentNotFound("Equipment not found with id $id")
    }

    override fun updateEquipment(equipment: Equipment): Equipment {
        return equipmentOutputPort.updateEquipment(equipment);
    }

}