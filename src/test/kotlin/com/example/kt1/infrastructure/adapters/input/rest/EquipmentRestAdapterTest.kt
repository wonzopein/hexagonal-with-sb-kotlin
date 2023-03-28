package com.example.kt1.infrastructure.adapters.input.rest

import com.example.kt1.domain.model.Equipment
import com.example.kt1.domain.model.EquipmentMode
import com.example.kt1.infrastructure.adapters.input.rest.data.request.EquipmentCreateRequest
import com.example.kt1.infrastructure.adapters.output.persistence.mapper.EquipmentPersistenceMapper
import com.example.kt1.infrastructure.adapters.output.persistence.repository.EquipmentRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@AutoConfigureMockMvc
class EquipmentRestAdapterTest(
        private var mockMvc: MockMvc,
        private var equipmentRepository: EquipmentRepository,
        //private var equipmenrRestMapper: EquipmentRestMapper,
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
                    .content(objectMapper.writeValueAsString(equipmentCreateRequest)))
                .andExpect(status().isCreated)
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
                        jsonPath("\$.id").value(entity.id),
                        jsonPath("\$.name").value(entity.name)
                )
                .andDo(print())
    }
}