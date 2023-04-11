package com.example.kt1.application.ports.output

import com.example.kt1.domain.equipment.model.Equipment
import org.springframework.data.domain.Pageable
import java.util.UUID

interface EquipmentOutputPort {
    fun createEquipment(equipment: Equipment): Equipment
    fun updateEquipment(equipment: Equipment): Equipment
    fun getEquipmentById(id: UUID): Equipment?
    fun listEquipments(pageable: Pageable): List<Equipment>
}