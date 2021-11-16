package com.kay.eatsomething.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kay.eatsomething.databinding.RecipesRowLayoutBinding
import com.kay.eatsomething.models.FoodRecipe
import com.kay.eatsomething.models.FoodTypeResult
import com.kay.eatsomething.util.RecipesDiffUtil

class RecipesAdapters : RecyclerView.Adapter<RecipesAdapters.MyViewHolder>() {

    private var recipe = emptyList<FoodTypeResult>()

    class MyViewHolder(val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // databinding or viewbinding?

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesAdapters.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return RecipesAdapters.MyViewHolder(
            RecipesRowLayoutBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentResult = recipe[position] // <- we might need to change this later.
    }

    override fun getItemCount(): Int {
        return recipe.size
    }

    fun setData(newData: FoodRecipe){
        val recipesDiffUtil = RecipesDiffUtil(recipe, newData.foodTypeResults) // <- the old list is recipe and the new list is newData.
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil) // <- This calculate the difference between those two list.
        recipe = newData.foodTypeResults
        diffUtilResult.dispatchUpdatesTo(this) // refer to this class (RecyclerView adapter)

    }
}