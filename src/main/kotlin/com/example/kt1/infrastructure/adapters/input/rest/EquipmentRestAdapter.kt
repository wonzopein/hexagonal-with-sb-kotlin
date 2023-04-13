package com.example.kt1.infrastructure.adapters.input.rest

import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentUpdateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentCreateResponse
import com.example.kt1.infrastructure.adapters.input.rest.data.response.EquipmentQueryResponse
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
    private val equipmentRestService: EquipmentRestService
) {
    @PostMapping()
    fun createEquipment(@RequestBody @Valid equipmentCreateRequest: EquipmentCreateRequest): ResponseEntity<EquipmentCreateResponse> {
        val response = equipmentRestService.createEquipment(equipmentCreateRequest)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateEquipment(
        @PathVariable id: UUID,
        @RequestBody @Valid equipmentUpdateRequest: EquipmentUpdateRequest
    ): ResponseEntity<Any> {
        val response = equipmentRestService.updateEquipment(id, equipmentUpdateRequest)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping
    fun listEquipment(@PageableDefault(size = 10, sort = ["createdAt"], direction = Sort.Direction.DESC) pageable: Pageable): ResponseEntity<List<EquipmentQueryResponse>> {
        val equipments =
            equipmentRestService.listEquipments(pageable)
        return ResponseEntity(equipments, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getEquipment(@PathVariable id: UUID): ResponseEntity<EquipmentQueryResponse> {
        val equipment = equipmentRestService.getEquipmentById(id)
        return ResponseEntity(equipment, HttpStatus.OK)
    }


}