package com.kay.eatsomething.models


import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("results")
    val foodTypeResults: List<FoodTypeResult>
)