package com.example.kt1.application.ports.input

import com.example.kt1.domain.equipment.model.Equipment

interface UpdateEquipmentUseCase {
    fun updateEquipment(equipment: Equipment): Equipment
}