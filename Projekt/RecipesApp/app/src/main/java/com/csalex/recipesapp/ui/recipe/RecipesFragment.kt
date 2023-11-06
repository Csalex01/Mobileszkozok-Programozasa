package com.csalex.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.csalex.recipesapp.R
import com.csalex.recipesapp.repository.recipe.RecipeRepository
import com.csalex.recipesapp.ui.recipe.viewmodel.RecipeListViewmodel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecipesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val TAG: String? = RecipesFragment::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        context?.let {
//            val recipes = RecipeRepository.getRecipes(it)
//
//            Log.d(TAG, "Number of recipes: ${recipes.size}")
//
//            for(recipe in recipes) {
//                Log.d(TAG, "Recipe: ${recipe.name}")
//            }
//        }

        val viewModel: RecipeListViewmodel = ViewModelProvider(this).get(RecipeListViewmodel::class.java)

        context?.let { viewModel.fetchRecipeData(it) }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes ->
            for(recipe in recipes) {
                Log.d(TAG, "Recipe name: ${recipe.name}")
                Log.d(TAG, "Recipe description: ${recipe.name}")
                Log.d(TAG, "----------")
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecipesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecipesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}