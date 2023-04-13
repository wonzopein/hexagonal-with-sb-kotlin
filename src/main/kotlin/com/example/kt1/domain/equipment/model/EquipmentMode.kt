package com.example.kt1.domain.equipment.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonFormat

/**
 * 설비상태
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class EquipmentMode(var code: Int, var description: String) {
    UNKNOWN(0, "알수없음"),
    AUTOMATIC(10, "자동"),
    SEMI_AUTOMATIC(11, "반-자동"),
    MANUAL(20, "수동");


    companion object {
        @JvmStatic
        @JsonCreator
        fun of(code: Int): EquipmentMode {
            return values().first { (it.code == code) }
        }
    }

}