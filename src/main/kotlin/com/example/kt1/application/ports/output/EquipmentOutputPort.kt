package com.example.kt1.application.ports.output

import com.example.kt1.domain.model.Equipment
import java.util.UUID

interface EquipmentOutputPort {
    fun createEquipment(equipment: Equipment): Equipment
    fun updateEquipment(equipment: Equipment): Equipment
    fun getEquipmentById(id: UUID): Equipment?
}