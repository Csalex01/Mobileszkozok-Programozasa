package com.csalex.recipesapp.repository.instruction.model

data class InstructionModel (
    val id: Int,
    val displayText: String,
    val time: InstructionTime
)

data class InstructionTime (
    val startTime: Int,
    val endTime: Int
)