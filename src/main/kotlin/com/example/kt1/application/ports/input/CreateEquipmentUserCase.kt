package com.example.kt1.application.ports.input

import com.example.kt1.domain.model.Equipment

interface CreateEquipmentUserCase {
    fun saveEquipment(equipment: Equipment): Equipment
}