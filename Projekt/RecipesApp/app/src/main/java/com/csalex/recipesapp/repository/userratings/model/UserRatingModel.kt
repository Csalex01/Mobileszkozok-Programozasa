package com.csalex.recipesapp.repository.userratings.model

data class UserRatingModel(
    val countPositive: Int,
    val countNegative: Int,
    val score: Float
)