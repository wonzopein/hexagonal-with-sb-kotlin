package com.example.kt1.infrastructure.adapters.configuration.coverter.attribute

import com.example.kt1.domain.equipment.model.EquipmentMode
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class EquipmentModeConverter : AttributeConverter<EquipmentMode, Int> {
    override fun convertToDatabaseColumn(attribute: EquipmentMode?): Int {
        return attribute?.code ?: throw IllegalArgumentException()
    }

    override fun convertToEntityAttribute(dbData: Int?): EquipmentMode {
        return EquipmentMode.of(dbData ?: throw IllegalArgumentException())
    }
}