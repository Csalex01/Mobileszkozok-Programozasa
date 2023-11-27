package com.csalex.recipesapp.repository.recipe.model

import com.csalex.recipesapp.repository.instruction.model.InstructionModel
import com.csalex.recipesapp.repository.userratings.model.UserRatingModel
import com.google.gson.annotations.SerializedName

data class RecipeModel(
    val name: String,
    val description: String? = "Default description",
    val instruction: List<InstructionModel>,
    val thumbnailUrl: String? = "",
    val userRating: UserRatingModel
)