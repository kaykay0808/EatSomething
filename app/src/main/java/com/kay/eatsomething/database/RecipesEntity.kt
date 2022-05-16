package com.kay.eatsomething.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kay.eatsomething.models.FoodRecipe
import com.kay.eatsomething.util.Constants.Companion.RECIPES_TABLE

//

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false) // <- fetch the newest data to our database
    var id: Int = 0
}
