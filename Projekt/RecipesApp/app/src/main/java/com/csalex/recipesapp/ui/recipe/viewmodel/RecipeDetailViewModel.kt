package com.csalex.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csalex.recipesapp.repository.recipe.RecipeRepository
import com.csalex.recipesapp.repository.recipe.model.RecipeModel

class RecipeDetailViewModel: ViewModel() {

    private val repository = RecipeRepository

    var recipeList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    /*
    fun fetchRecipeDetail(recipeId: Int) {
        recipeList.value = repository.getRecipeById(recipeId)
    }
     */

}
