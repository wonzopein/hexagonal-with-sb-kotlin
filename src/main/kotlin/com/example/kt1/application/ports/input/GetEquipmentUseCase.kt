package com.example.kt1.application.ports.input

import com.example.kt1.domain.model.Equipment

interface GetEquipmentUseCase {
    fun getEquipmentById(id: Long) : Equipment
}