package com.csalex.recipesapp.repository.recipe

import android.content.Context
import com.csalex.recipesapp.repository.recipe.model.RecipeModel
import com.csalex.recipesapp.repository.recipe.model.RecipesDTO
import com.csalex.recipesapp.repository.recipe.model.toModelList
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson

object RecipeRepository {

    private val TAG: String? = RecipeRepository::class.simpleName
    private var myRecipes : List<RecipeModel>? = emptyList()

    fun getRecipes(context: Context): List<RecipeModel> {
        lateinit var jsonString: String

        try {
            jsonString = context.assets.open("recipes.json").bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val recipesResponse: RecipesDTO = Gson().fromJson(jsonString, object: TypeToken<RecipesDTO>() {}.type)

        return recipesResponse.results.toModelList()
    }

    fun getRecipeById(context: Context, recipeId: Int): RecipeModel {
        return getRecipes(context).first { it.id == recipeId }
    }

    fun insertMyRecipe(recipe: RecipeModel) {
        myRecipes = myRecipes?.plus(recipe)
    }

    fun getMyRecipes() : List<RecipeModel>? = this.myRecipes

}