package com.example.kt1.application.ports.output

import com.example.kt1.domain.model.Equipment

interface EquipmentOutputPort {
    fun saveEquipment(equipment: Equipment): Equipment
    fun getEquipmentById(id: Long): Equipment?
}