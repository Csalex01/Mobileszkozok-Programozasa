package com.csalex.recipesapp.ui.recipe

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csalex.recipesapp.R
import com.csalex.recipesapp.databinding.FragmentRecipesBinding
import com.csalex.recipesapp.repository.recipe.model.RecipeModel
import com.csalex.recipesapp.ui.recipe.adapter.RecipeListAdapter
import com.csalex.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

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

    private val TAG: String? = RecipesFragment::class.simpleName
    private lateinit var binding: FragmentRecipesBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_recipes, container, false)

        binding = FragmentRecipesBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        findNavController()
            .navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id)
            )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: RecipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        val recyclerView: RecyclerView = view.findViewById(R.id.recipesRecyclerView)
        var adapter: RecipeListAdapter = RecipeListAdapter(listOf(), requireContext(), {}, {})

        context?.let { viewModel.fetchRecipeData(it) }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes: List<RecipeModel> ->
            for(recipe in recipes) {
                Log.d(TAG, "Recipe name: ${recipe.name}")
                Log.d(TAG, "Recipe description: ${recipe.name}")
                Log.d(TAG, "Recipe instruction: ${recipe.instruction}")
                Log.d(TAG, "----------")
            }

            adapter = RecipeListAdapter(
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

        binding.searchButton.setOnClickListener {
            val searchTextView = binding.searchTextView
            val searchText = searchTextView.text.toString()

            val filteredRecipes = viewModel.recipeList.value?.filter { recipe ->
                recipe.name.contains(searchText, ignoreCase = true)
            }

            Log.d(TAG, "Filtered recipes: $filteredRecipes")

            if(filteredRecipes == null)  return@setOnClickListener

            adapter.recipeList = filteredRecipes
            adapter.notifyDataSetChanged()
        }

        binding.sortByRatingsButton.setOnClickListener {
            val sortedRecipes = viewModel.recipeList.value?.sortedByDescending { recipe ->
                recipe.userRating.score
            } ?: return@setOnClickListener

            adapter.recipeList = sortedRecipes
            adapter.notifyDataSetChanged()
        }
    }
}