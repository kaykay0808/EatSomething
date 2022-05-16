package com.kay.eatsomething.data

import com.kay.eatsomething.data.network.FoodRecipesApi
import com.kay.eatsomething.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

// TODO: After creating network module, inject our remote datasource class with the foodRecipesApi

// We will have 2 different data sources
// 1: the first one is a remote data source which will fetch data from our foodRecipesApi/SpoonacularApi
// 2: second data source will be a local data source which will handle a local database

// --(The Repository will inject those two data sources)--

// inject recipes/recipesApi.
// specify which type you are going to inject (Hilt will basically search for this specific type in this network module, and it will search for a function which returns the same type)
class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {
    // We are going to add multiple queries to our get request.
    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}
