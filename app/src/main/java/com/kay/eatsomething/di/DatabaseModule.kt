package com.kay.eatsomething.di

import android.content.Context
import androidx.room.Room
import com.kay.eatsomething.database.RecipesDatabase
import com.kay.eatsomething.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Hilt provide our RoomDatabase builder and our RecipeDao through this database
// Later we will inject this in to other classes.

@Module
@InstallIn(SingletonComponent::class) // <- need to specify component
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RecipesDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: RecipesDatabase) = database.recipesDao()
}