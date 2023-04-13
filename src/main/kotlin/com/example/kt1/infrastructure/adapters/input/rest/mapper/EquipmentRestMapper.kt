package com.example.kt1.infrastructure.adapters.input.rest.mapper

import com.example.kt1.domain.equipment.model.Equipment
import com.example.kt1.domain.equipment.model.EquipmentMode
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentUpdateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentCreateResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentQueryResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentUpdateResponse
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class EquipmentRestMapper {

    abstract fun toEquipment(equipmentCreateRequest: EquipmentCreateRequest): Equipment
    abstract fun toEquipmentCreateResponse(equipment: Equipment): EquipmentCreateResponse
    abstract fun toEquipmentQueryResponse(equipment: Equipment): EquipmentQueryResponse
    abstract fun toEquipmentUpdateResponse(equipment: Equipment): EquipmentUpdateResponse
    abstract fun toEquipment(equipmentUpdateRequest: EquipmentUpdateRequest): Equipment

    fun map(code: Int) : EquipmentMode {
        return EquipmentMode.of(code)
    }
//
//    fun map(equipmentMode: EquipmentMode): Int {
//        return equipmentMode.code
//    }

}