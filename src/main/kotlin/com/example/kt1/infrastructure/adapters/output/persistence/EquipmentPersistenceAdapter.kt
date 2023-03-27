package com.example.kt1.infrastructure.adapters.output.persistence

import com.example.kt1.application.ports.output.EquipmentOutputPort
import com.example.kt1.domain.model.Equipment
import com.example.kt1.infrastructure.adapters.output.persistence.mapper.EquipmentPersistenceMapper
import com.example.kt1.infrastructure.adapters.output.persistence.repository.EquipmentRepository
import org.springframework.data.repository.findByIdOrNull

class EquipmentPersistenceAdapter(
        private var equipmentRepository: EquipmentRepository,
        private var equipmentPersistenceMapper: EquipmentPersistenceMapper
) : EquipmentOutputPort {


    override fun saveEquipment(equipment: Equipment): Equipment {

        var equipmentEntity  = equipmentPersistenceMapper.toEquipmentEntity(equipment)
        equipmentEntity = equipmentRepository.save(equipmentEntity)
        return equipmentPersistenceMapper.toEquipment(equipmentEntity)
    }

    override fun getEquipmentById(id: Long): Equipment? {
        var equipmentEntity = equipmentRepository.findByIdOrNull(id) ?: return null
        return equipmentPersistenceMapper.toEquipment(equipmentEntity)
    }
}