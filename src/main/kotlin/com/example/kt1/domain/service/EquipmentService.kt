package com.example.kt1.domain.service

import com.example.kt1.application.ports.input.CreateEquipmentUserCase
import com.example.kt1.application.ports.input.GetEquipmentUseCase
import com.example.kt1.application.ports.output.EquipmentEventPublisher
import com.example.kt1.application.ports.output.EquipmentOutputPort
import com.example.kt1.domain.event.EquipmentCreateEvent
import com.example.kt1.domain.exception.EquipmentNotFound
import com.example.kt1.domain.model.Equipment

class EquipmentService(
        private var equipmentOutputPort: EquipmentOutputPort,
        private var equipmentEventPublisher: EquipmentEventPublisher
) : CreateEquipmentUserCase, GetEquipmentUseCase {

    override fun saveEquipment(equipment: Equipment): Equipment {
        var equipment = equipmentOutputPort.saveEquipment(equipment)
        equipmentEventPublisher.publishEquipmentCreateEvent(EquipmentCreateEvent(equipment.id))
        return equipment
    }

    override fun getEquipmentById(id: Long): Equipment {
        return equipmentOutputPort.getEquipmentById(id) ?: throw EquipmentNotFound("Equipment not found with id $id")
    }

}