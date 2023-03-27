package com.example.kt1.infrastructure.adapters.configuration

import com.example.kt1.domain.service.EquipmentService
import com.example.kt1.infrastructure.adapters.output.eventpublisher.EquipmentEventPublisherAdapter
import com.example.kt1.infrastructure.adapters.output.persistence.EquipmentPersistenceAdapter
import com.example.kt1.infrastructure.adapters.output.persistence.mapper.EquipmentPersistenceMapper
import com.example.kt1.infrastructure.adapters.output.persistence.repository.EquipmentRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun equipmentPersistenceAdapter(
            equipmentRepository: EquipmentRepository,
            equipmentPersistenceMapper: EquipmentPersistenceMapper
    ): EquipmentPersistenceAdapter {
        return EquipmentPersistenceAdapter(equipmentRepository, equipmentPersistenceMapper)
    }

    @Bean
    fun equipmentEventPublisherAdapter(
            applicationEventPublisher: ApplicationEventPublisher
    ): EquipmentEventPublisherAdapter {
        return EquipmentEventPublisherAdapter(applicationEventPublisher)
    }

    @Bean
    fun equipmentService(equipmentPersistenceAdapter: EquipmentPersistenceAdapter,
                         equipmentEventPublisherAdapter: EquipmentEventPublisherAdapter
    ): EquipmentService {
        return EquipmentService(equipmentPersistenceAdapter, equipmentEventPublisherAdapter)
    }

}