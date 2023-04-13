package com.example.kt1.infrastructure.adapters.input.rest

import com.example.kt1.application.ports.input.CreateEquipmentUserCase
import com.example.kt1.application.ports.input.GetEquipmentUseCase
import com.example.kt1.application.ports.input.UpdateEquipmentUseCase
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentUpdateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentCreateResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentQueryResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentUpdateResponse
import com.example.kt1.infrastructure.adapters.input.rest.mapper.EquipmentRestMapper
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class EquipmentRestService(
    private val createEquipmentUserCase: CreateEquipmentUserCase,
    private val updateEquipmentUseCase: UpdateEquipmentUseCase,
    private val getEquipmentUseCase: GetEquipmentUseCase,
    private val equipmentRestMapper: EquipmentRestMapper
) {

    fun createEquipment(equipmentCreateRequest: EquipmentCreateRequest) :  EquipmentCreateResponse {
        var equipment = equipmentRestMapper.toEquipment(equipmentCreateRequest)
        equipment = createEquipmentUserCase.createEquipment(equipment)
        return equipmentRestMapper.toEquipmentCreateResponse(equipment)
    }

    fun updateEquipment(id: UUID, equipmentUpdateRequest: EquipmentUpdateRequest): EquipmentUpdateResponse {
        equipmentUpdateRequest.id = id
        var equipment = equipmentRestMapper.toEquipment(equipmentUpdateRequest)

        /**
        var equipment = Equipment()
        equipment.id = id
        equipment.name = equipmentUpdateRequest.name
        equipment.description = equipmentUpdateRequest.description
        equipment.updatedBy = equipmentUpdateRequest.updatedBy
        equipment.mode = EquipmentMode.of(equipmentUpdateRequest.mode)
        */

        equipment = updateEquipmentUseCase.updateEquipment(equipment)
        return equipmentRestMapper.toEquipmentUpdateResponse(equipment)
    }

    fun getEquipmentById(id: UUID): EquipmentQueryResponse {
        val equipment = getEquipmentUseCase.getEquipmentById(id)
        return equipmentRestMapper.toEquipmentQueryResponse(equipment)
    }

    fun listEquipments(pageable: Pageable): List<EquipmentQueryResponse> {
        return getEquipmentUseCase.listEquipments(pageable)
                .map { equipmentRestMapper.toEquipmentQueryResponse(it) }
                .toList()
    }
}