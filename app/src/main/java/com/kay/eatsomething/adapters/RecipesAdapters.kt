package com.kay.eatsomething.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kay.eatsomething.R
import com.kay.eatsomething.databinding.RecipesRowLayoutBinding
import com.kay.eatsomething.models.FoodRecipe
import com.kay.eatsomething.models.FoodTypeResult
import com.kay.eatsomething.util.RecipesDiffUtil

class RecipesAdapters : RecyclerView.Adapter<RecipesAdapters.MyViewHolder>() {

    private var recipes = emptyList<FoodTypeResult>()

    class MyViewHolder(val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipesAdapters.MyViewHolder {
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
        val currentRecipe = recipes[position] // <- we might need to change this later.
        val color = holder.binding.leafImageView.context.getColor(R.color.green)
        // load image from URL
        holder.binding.recipeImageView.load(currentRecipe.image) {
            crossfade(600)
            error(R.drawable.ic_error_placeholder) // <- If no connection an error picture will load instead.
        }

        // set number of likes(<3)
        holder.binding.heartTextView.text = currentRecipe.aggregateLikes.toString()
        // set number of minutes
        holder.binding.clockTextView.text = currentRecipe.readyInMinutes.toString()
        // vegan image?
        holder.binding.leafImageView.colorFilter =
            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                color,
                BlendModeCompat.SRC_ATOP
            )
        // heart image?
        holder.binding.heartImageView
        // set title
        holder.binding.titleTextView.text = currentRecipe.title
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun setData(newData: FoodRecipe) {
        val recipesDiffUtil = RecipesDiffUtil(
            recipes,
            newData.foodTypeResults
        ) // <- the old list is recipe and the new list is newData.
        val diffUtilResult =
            DiffUtil.calculateDiff(recipesDiffUtil) // <- This calculate the difference between those two list.
        recipes = newData.foodTypeResults
        diffUtilResult.dispatchUpdatesTo(this) // refer to this class (RecyclerView adapter)
    }
}
