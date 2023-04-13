package com.example.kt1.domain.equipment.service

import com.example.kt1.application.ports.input.CreateEquipmentUserCase
import com.example.kt1.application.ports.input.GetEquipmentUseCase
import com.example.kt1.application.ports.input.UpdateEquipmentUseCase
import com.example.kt1.application.ports.output.EquipmentEventPublisher
import com.example.kt1.application.ports.output.EquipmentPersistencePort
import com.example.kt1.domain.equipment.event.EquipmentCreateEvent
import com.example.kt1.domain.equipment.event.EquipmentUpdateEvent
import com.example.kt1.domain.equipment.exception.EquipmentNotFound
import com.example.kt1.domain.equipment.model.Equipment
import org.springframework.data.domain.Pageable
import java.util.UUID

class EquipmentService(
    private var equipmentPersistencePort: EquipmentPersistencePort,
    private var equipmentEventPublisher: EquipmentEventPublisher
) : CreateEquipmentUserCase, UpdateEquipmentUseCase, GetEquipmentUseCase {

    override fun createEquipment(equipment: Equipment): Equipment {
        val persistenceEquipment = equipmentPersistencePort.createEquipment(equipment)
        equipmentEventPublisher.publishEquipmentCreateEvent(EquipmentCreateEvent(persistenceEquipment.id))
        return persistenceEquipment
    }

    override fun getEquipmentById(id: UUID): Equipment {
        return equipmentPersistencePort.getEquipmentById(id) ?: throw EquipmentNotFound("Equipment not found with id $id")
    }

    override fun listEquipments(pageable: Pageable): List<Equipment> {
        return equipmentPersistencePort.listEquipments(pageable)
    }

    override fun updateEquipment(equipment: Equipment): Equipment {
        equipmentPersistencePort.updateEquipment(equipment)
        equipmentEventPublisher.publishEquipmentUpdateEvent(EquipmentUpdateEvent(equipment.id))
        return equipment
    }

}