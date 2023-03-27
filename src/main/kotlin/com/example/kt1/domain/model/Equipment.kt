package com.example.kt1.domain.model

import java.time.LocalDateTime


class Equipment {
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    var createdAt: LocalDateTime? = null
    var createBy: String? = null
    var updatedAt: LocalDateTime? = null
    var updatedBy: String? = null
}