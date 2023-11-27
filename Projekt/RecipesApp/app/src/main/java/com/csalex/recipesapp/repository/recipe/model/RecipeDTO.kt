package com.csalex.recipesapp.repository.recipe.model

import com.csalex.recipesapp.repository.instruction.model.InstructionDTO
import com.csalex.recipesapp.repository.instruction.model.toModelList
import com.csalex.recipesapp.repository.userratings.model.UserRatingDTO
import com.csalex.recipesapp.repository.userratings.model.toModel
import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val instructions: List<InstructionDTO>,

    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = "",

    @SerializedName("user_ratings")
    val userRatingDTO: UserRatingDTO
)

fun RecipeDTO.toModel(): RecipeModel =
    RecipeModel (
        name = this.name,
        description = this.description,
        instruction = this.instructions.toModelList(),
        thumbnailUrl = this.thumbnailUrl,
        userRating = this.userRatingDTO.toModel()
    )

fun List<RecipeDTO>.toModelList(): List<RecipeModel> =
    this.map { it.toModel() }