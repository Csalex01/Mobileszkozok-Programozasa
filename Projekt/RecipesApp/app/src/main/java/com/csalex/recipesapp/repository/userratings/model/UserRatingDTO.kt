package com.csalex.recipesapp.repository.userratings.model

import com.google.gson.annotations.SerializedName

data class UserRatingDTO(
    @SerializedName("count_positive")
    val countPositive: Int,

    @SerializedName("count_negative")
    val countNegative: Int,

    val score: Float
)

fun UserRatingDTO.toModel(): UserRatingModel =
    UserRatingModel (
        countPositive = this.countPositive,
        countNegative = this.countNegative,
        score = this.score
    )