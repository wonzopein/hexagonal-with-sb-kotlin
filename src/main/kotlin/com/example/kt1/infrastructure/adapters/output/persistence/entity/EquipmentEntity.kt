package com.example.kt1.infrastructure.adapters.output.persistence.entity

import com.example.kt1.domain.equipment.model.EquipmentMode
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.UuidGenerator
import java.util.*

@Entity
class EquipmentEntity : BaseTimeEntity() {

//    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name="uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "BINARY(16)")
    @Id
    @GeneratedValue
    @UuidGenerator
    var id: UUID? = null
    var name: String? = null
    var description: String? = null
    var mode: EquipmentMode = EquipmentMode.UNKNOWN

}