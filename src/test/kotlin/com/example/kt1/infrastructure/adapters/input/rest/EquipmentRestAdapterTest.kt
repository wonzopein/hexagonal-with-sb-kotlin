package com.example.kt1.infrastructure.adapters.input.rest

import com.example.kt1.domain.model.Equipment
import com.example.kt1.domain.model.EquipmentMode
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentUpdateRequest
import com.example.kt1.infrastructure.adapters.input.rest.mapper.EquipmentRestMapper
import com.example.kt1.infrastructure.adapters.output.persistence.mapper.EquipmentPersistenceMapper
import com.example.kt1.infrastructure.adapters.output.persistence.repository.EquipmentRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.UUID


@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@AutoConfigureMockMvc
class EquipmentRestAdapterTest(
    private var mockMvc: MockMvc,
    private var equipmentRepository: EquipmentRepository,
    private var equipmenrRestMapper: EquipmentRestMapper,
    private var equipmentPersistenceMapper: EquipmentPersistenceMapper,
    private var objectMapper: ObjectMapper
) {

    @Test
    @DisplayName("설비 생성")
    fun createEquipment() {
        val equipmentCreateRequest = EquipmentCreateRequest("설비-A1", "-")

        mockMvc.perform(
            post("/v1/equipments")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(equipmentCreateRequest))
        )
            .andExpect(status().isCreated)
            .andExpectAll(
                jsonPath("\$.id").isNotEmpty(),
                jsonPath("\$.mode.code").value(EquipmentMode.UNKNOWN.code)
            )
            .andDo(print())
    }

    @Test
    @DisplayName("설비 변경")
    fun updateEquipment() {

        val equipment = Equipment()
        equipment.name = "테스트 설비-A"
        equipment.description = "설명-A"
        equipment.mode = EquipmentMode.SEMI_AUTOMATIC
        var entity = equipmentPersistenceMapper.toEquipmentEntity(equipment)
        entity = equipmentRepository.save(entity)

        val equipmentUpdateRequest = EquipmentUpdateRequest()
        equipmentUpdateRequest.updatedBy = "암오너"
        equipmentUpdateRequest.name = "테스트 설비-A1"
        equipmentUpdateRequest.mode = EquipmentMode.MANUAL.code

        val content = ObjectMapper()
            .registerModule(JavaTimeModule())
            .writeValueAsString(equipmentUpdateRequest)

        mockMvc.perform(put("/v1/equipments/{id}", entity.id)
            .contentType("application/json")
            .content(content)
            )
            .andExpect(status().isOk)
            .andExpectAll(
                jsonPath("\$.name").value(equipmentUpdateRequest.name),
                jsonPath("\$.mode.code").value(equipmentUpdateRequest.mode)
            )
            .andDo(print())
    }

    @Test
    @DisplayName("설비 조회 - 단건")
    fun getEquipment() {

        val equipment = Equipment()
        equipment.name = "테스트 설비-A"
        equipment.description = "설명-A"
        equipment.mode = EquipmentMode.SEMI_AUTOMATIC

        var entity = equipmentPersistenceMapper.toEquipmentEntity(equipment)
        entity = equipmentRepository.save(entity)

        mockMvc.perform(get("/v1/equipments/{id}", entity.id))
            .andExpect(status().isOk)
            .andExpectAll(
                jsonPath("\$.id").value(entity.id.toString()),
                jsonPath("\$.name").value(entity.name),
                jsonPath("\$.mode.code").value(EquipmentMode.SEMI_AUTOMATIC.code)
            )
            .andDo(print())
    }

    @Test
    @DisplayName("설비 조회 - 실패 404")
    fun getEquipmentNotFountException(){
        val equipment = Equipment()
        equipment.id = UUID.randomUUID()
        equipment.name = "테스트 설비-A"
        equipment.description = "설명-A"
        equipment.mode = EquipmentMode.SEMI_AUTOMATIC

        mockMvc.perform(get("/v1/equipments/{id}", equipment.id))
            .andExpect(status().is4xxClientError)
            .andExpectAll(
                jsonPath("\$.date").isNotEmpty
            )
            .andDo(print())
    }
}