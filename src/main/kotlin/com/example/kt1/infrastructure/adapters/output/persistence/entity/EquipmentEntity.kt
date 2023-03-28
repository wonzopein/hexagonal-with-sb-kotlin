package com.example.kt1.infrastructure.adapters.output.persistence.entity

import com.example.kt1.domain.model.EquipmentMode
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class EquipmentEntity : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    var mode: EquipmentMode = EquipmentMode.UNKNOWN

}