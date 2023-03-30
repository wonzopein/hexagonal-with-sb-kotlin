package com.example.kt1.infrastructure.adapters.input.rest.mapper

import com.example.kt1.domain.model.Equipment
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentCreateResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentQueryResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface EquipmentRestMapper {

    fun toEquipment(equipmentCreateRequest: EquipmentCreateRequest): Equipment
    fun toEquipmentCreateResponse(equipment: Equipment): EquipmentCreateResponse
    fun toEquipmentQueryResponse(equipment: Equipment): EquipmentQueryResponse

}