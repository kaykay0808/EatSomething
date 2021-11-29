package com.kay.eatsomething.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// Contains the database holder and serves as the main access pont for the underlying connection your app's persisted, relational data.

@Database(
    entities = [RecipesEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RecipesTypeConverter::class) // <-- this is for our converter.
abstract class RecipesDatabase: RoomDatabase() {

    abstract fun recipesDao(): RecipesDao

}