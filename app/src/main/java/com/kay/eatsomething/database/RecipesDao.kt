package com.kay.eatsomething.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    // (1) Inserting the data
    @Insert(onConflict = OnConflictStrategy.REPLACE) // whenever we fetch a new data from our API, we want to replace the old one. (we had "ignore" in our todoapp)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    // Reading the live data
    @Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>> // Flow (kotlinx.coroutines.flow) (Flow instead of LiveData?)
}
