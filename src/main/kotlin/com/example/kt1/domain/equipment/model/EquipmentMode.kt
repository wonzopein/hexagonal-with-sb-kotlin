package com.example.kt1.domain.equipment.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonFormat

/**
 * 설비상태
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class EquipmentMode {
    UNKNOWN(0, "알수없음"),
    AUTOMATIC(10, "자동"),
    SEMI_AUTOMATIC(11, "반-자동"),
    MANUAL(20, "수동");

    var code: Int = 0
    lateinit var description: String

    constructor()
    constructor(code: Int, description: String) {
        this.code = code
        this.description = description
    }

    companion object {
        @JsonCreator
        fun of(code: Int): EquipmentMode {
            return values().first { (it.code == code) }
        }
    }

}