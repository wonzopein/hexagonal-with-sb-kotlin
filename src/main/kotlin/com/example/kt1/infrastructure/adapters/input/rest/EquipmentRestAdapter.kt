package com.example.kt1.infrastructure.adapters.input.rest

import com.example.kt1.application.ports.input.CreateEquipmentUserCase
import com.example.kt1.application.ports.input.GetEquipmentUseCase
import com.example.kt1.application.ports.input.UpdateEquipmentUseCase
import com.example.kt1.domain.model.Equipment
import com.example.kt1.domain.model.EquipmentMode
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentUpdateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentCreateResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentQueryResponse
import com.example.kt1.infrastructure.adapters.input.rest.mapper.EquipmentRestMapper
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/equipments")
class EquipmentRestAdapter(
    private val createEquipmentUserCase: CreateEquipmentUserCase,
    private val updateEquipmentUseCase: UpdateEquipmentUseCase,
    private val getEquipmentUseCase: GetEquipmentUseCase,
    private val equipmentRestMapper: EquipmentRestMapper
) {

    @PostMapping()
    fun createEquipment(@RequestBody @Valid equipmentCreateRequest: EquipmentCreateRequest): ResponseEntity<EquipmentCreateResponse> {
        var equipment = equipmentRestMapper.toEquipment(equipmentCreateRequest)
        equipment = createEquipmentUserCase.createEquipment(equipment)
        val response = equipmentRestMapper.toEquipmentCreateResponse(equipment)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateEquipment(
        @PathVariable id: UUID?,
        @RequestBody @Valid equipmentUpdateRequest: EquipmentUpdateRequest
    ): ResponseEntity<Any> {

        var equipment = Equipment()
        equipment.id = id
        equipment.name = equipmentUpdateRequest.name
        equipment.description = equipmentUpdateRequest.description
        equipment.updatedBy = equipmentUpdateRequest.updatedBy
        equipment.mode = EquipmentMode.of(equipmentUpdateRequest.mode)
        equipment = updateEquipmentUseCase.updateEquipment(equipment)
        return ResponseEntity(equipmentRestMapper.toEquipmentUpdateResponse(equipment), HttpStatus.OK)
    }

    @GetMapping
    fun listEquipment(@PageableDefault(size = 10, sort = ["createdAt"], direction = Sort.Direction.DESC) pageable: Pageable): ResponseEntity<List<EquipmentQueryResponse>> {
        val equipments =
            getEquipmentUseCase.listEquipments(pageable)
                .map { equipmentRestMapper.toEquipmentQueryResponse(it) }
                .toList()
        return ResponseEntity(equipments, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getEquipment(@PathVariable id: UUID): ResponseEntity<EquipmentQueryResponse> {
        val equipment = getEquipmentUseCase.getEquipmentById(id)
        return ResponseEntity(equipmentRestMapper.toEquipmentQueryResponse(equipment), HttpStatus.OK)
    }


}