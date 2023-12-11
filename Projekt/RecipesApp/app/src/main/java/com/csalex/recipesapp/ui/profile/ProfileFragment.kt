package com.csalex.recipesapp.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csalex.recipesapp.R
import com.csalex.recipesapp.databinding.FragmentProfileBinding
import com.csalex.recipesapp.repository.recipe.RecipeRepository
import com.csalex.recipesapp.repository.recipe.model.RecipeModel
import com.csalex.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.csalex.recipesapp.ui.recipe.viewmodel.RecipeListViewModel


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding
    private val TAG: String? = ProfileFragment::class.simpleName
    private lateinit var myRecipes : List<RecipeModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: RecipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        val recyclerView: RecyclerView = view.findViewById(R.id.myRecipesRecyclerView)

        context?.let { viewModel.fetchMyRecipeData() }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes: List<RecipeModel> ->
            for(recipe in recipes) {
                Log.d(TAG, "Recipe name: ${recipe.name}")
                Log.d(TAG, "Recipe description: ${recipe.name}")
                Log.d(TAG, "Recipe instruction: ${recipe.instruction}")
                Log.d(TAG, "----------")

                val adapter = RecipeListAdapter(
                    recipes,
                    requireContext(),

                    onItemClick = {
                            currentRecipe: RecipeModel -> navigateToRecipeDetail(currentRecipe)
                    },

                    onDetailsClick = {
                            currentRecipe: RecipeModel -> navigateToRecipeDetail(currentRecipe)
                    }
                )

                // Attach adapter to recycler view
                recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                recyclerView.adapter = adapter
            }
        }

//        for(recipe in myRecipes) {
//            Log.d(TAG, "Recipe: $recipe")
//        }

        binding.addFloatingActionButton.setOnClickListener {
            Log.d(TAG, "Clicked")
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        findNavController()
            .navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id)
            )
    }
}