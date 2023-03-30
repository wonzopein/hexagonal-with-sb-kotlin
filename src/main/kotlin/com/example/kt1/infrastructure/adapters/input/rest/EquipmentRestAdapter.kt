package com.example.kt1.infrastructure.adapters.input.rest

import com.example.kt1.application.ports.input.CreateEquipmentUserCase
import com.example.kt1.application.ports.input.GetEquipmentUseCase
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentCreateResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentQueryResponse
import com.example.kt1.infrastructure.adapters.input.rest.mapper.EquipmentRestMapper
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class EquipmentRestAdapter(
    private val createEquipmentUserCase: CreateEquipmentUserCase,
    private val getEquipmentUseCase: GetEquipmentUseCase,
    private val equipmentRestMapper: EquipmentRestMapper
) {

    @PostMapping("/equipments")
    fun createEquipment(@RequestBody @Valid equipmentCreateRequest: EquipmentCreateRequest): ResponseEntity<EquipmentCreateResponse> {
        var equipment = equipmentRestMapper.toEquipment(equipmentCreateRequest)
        equipment = createEquipmentUserCase.saveEquipment(equipment)
        val response = equipmentRestMapper.toEquipmentCreateResponse(equipment)

        println("createEquipment - ${response.id} ")

        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping("/equipments/{id}")
    fun getEquipment(@PathVariable id: Long): ResponseEntity<EquipmentQueryResponse> {
        val equipment = getEquipmentUseCase.getEquipmentById(id)
        return ResponseEntity(equipmentRestMapper.toEquipmentQueryResponse(equipment), HttpStatus.OK)
    }
}