package com.example.kt1.application.ports.input

import com.example.kt1.domain.equipment.model.Equipment
import org.springframework.data.domain.Pageable
import java.util.UUID

interface GetEquipmentUseCase {
    fun getEquipmentById(id: UUID): Equipment
    fun listEquipments(pageable: Pageable): List<Equipment>
}