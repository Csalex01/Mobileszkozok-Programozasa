package com.csalex.recipesapp.repository.instruction.model

import com.google.gson.annotations.SerializedName

data class InstructionDTO (
    val id: Int,

    val appliance: String?,

    @SerializedName("start_time")
    val startTime: Int,

    @SerializedName("end_time")
    val endTime: Int,

    val temperature: String?,

    val position: Int,

    @SerializedName("display_text")
    val displayText: String,
)

fun InstructionDTO.toModel(): InstructionModel =
    InstructionModel (
        id = this.id,
        displayText = this.displayText,
        time = InstructionTime(
            startTime = this.startTime,
            endTime = this.endTime
        )
    )

fun List<InstructionDTO>.toModelList(): List<InstructionModel> =
    this.map { it.toModel() }