package com.csalex.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csalex.recipesapp.repository.recipe.RecipeRepository
import com.csalex.recipesapp.repository.recipe.model.RecipeModel

class RecipeListViewModel: ViewModel() {

    private val repository = RecipeRepository

    var recipeList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchRecipeData(context: Context) {
        recipeList.value = repository.getRecipes(context)
    }

}