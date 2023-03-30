package com.example.kt1.infrastructure.adapters.output.persistence.mapper

import com.example.kt1.domain.model.Equipment
import com.example.kt1.infrastructure.adapters.output.persistence.entity.EquipmentEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface EquipmentPersistenceMapper {
    fun toEquipmentEntity(equipment: Equipment): EquipmentEntity
    fun toEquipment(equipmentEntity: EquipmentEntity): Equipment
}