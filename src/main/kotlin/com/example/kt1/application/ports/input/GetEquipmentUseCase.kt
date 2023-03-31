package com.example.kt1.application.ports.input

import com.example.kt1.domain.model.Equipment
import java.util.UUID

interface GetEquipmentUseCase {
    fun getEquipmentById(id: UUID): Equipment
}