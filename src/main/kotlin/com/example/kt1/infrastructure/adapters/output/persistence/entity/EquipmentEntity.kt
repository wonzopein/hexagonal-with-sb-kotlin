package com.example.kt1.infrastructure.adapters.output.persistence.entity

import com.example.kt1.domain.model.EquipmentMode
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class EquipmentEntity(var name: String, var description: String) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var mode: EquipmentMode = EquipmentMode.UNKNOWN

}