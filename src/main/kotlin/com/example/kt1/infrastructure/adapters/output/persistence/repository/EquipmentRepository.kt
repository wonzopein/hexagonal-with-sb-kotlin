package com.example.kt1.infrastructure.adapters.output.persistence.repository

import com.example.kt1.infrastructure.adapters.output.persistence.entity.EquipmentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EquipmentRepository : JpaRepository<EquipmentEntity, Long> {
}