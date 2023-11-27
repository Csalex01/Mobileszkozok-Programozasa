package com.csalex.recipesapp.ui.recipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.csalex.recipesapp.R
import com.csalex.recipesapp.repository.recipe.model.RecipeModel

class RecipeListAdapter(
    private var recipeList: List<RecipeModel>,
    private val context: Context
): RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder (view){
        val titleView: TextView
        val descriptionView: TextView
        val imageView: ImageView
        val ratingsView: TextView

        init {
            titleView = view.findViewById(R.id.recipeTitle)
            descriptionView = view.findViewById(R.id.recipeDescription)
            imageView = view.findViewById(R.id.recipePhoto)
            ratingsView = view.findViewById(R.id.recipeScore)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_list_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.titleView.text = recipeList[position].name
        holder.descriptionView.text = recipeList[position].description

        val rating = String.format("%.2f", recipeList[position].userRating.score * 10).toDouble()

        holder.ratingsView.text = "$rating/10"

        Glide.with(context)
            .load(recipeList[position].thumbnailUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .fallback(R.drawable.ic_launcher_foreground)
            .into(holder.imageView)
    }
}