package com.kay.eatsomething.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kay.eatsomething.models.FoodRecipe

// We cannot store complex objects in our database directly, so instead we need to convert our
// acceptable types so we can actually store them in a database.
// -> We're going to convert our "foodRecipe object" into a Json or a Sting
// -> When we are writing to our database and convert back from that string or Json back to our "foodRecipe object"

class RecipesTypeConverter {
    // first function will convert the recipe to String
    // second function will convert String back foodRecipe object

    // Initialize Gson object
    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        val listType = object : TypeToken<FoodRecipe>() {}.type
        return gson.fromJson(data, listType)
    }
}
