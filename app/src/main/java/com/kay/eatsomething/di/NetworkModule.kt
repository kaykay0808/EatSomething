package com.kay.eatsomething.di

import com.kay.eatsomething.Constants.Companion.BASE_URL
import com.kay.eatsomething.FoodRecipesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) // <- need to specify component
object NetworkModule {

    // (4) Need to create a function which provide OkhttpClient
    @Singleton
    @Provides
    fun provideHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    // (3) Need to create a function which basically provide jSonConvertaerFactory
    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory{
        // Hilt Library will know where to find JsonConverterFactory dependency in a return type of a function.
        return GsonConverterFactory.create()

    }

    // (2). Create a provider for our Retrofit instance?, and we need to satisfied 2 dependencies which is OkhttpClient and GsonConverterFactory
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL) // base url from the constants class
            .client(okHttpClient) // client is already provided in our parameter.
            .addConverterFactory(gsonConverterFactory) // from our parameter.
            .build()
    }

    // (1)
    @Singleton // <- we are using application scoope for the recipesApi
    @Provides // <- we are using retrofit library which is an external library not created by me.
    fun provideApiService(retrofit: Retrofit): FoodRecipesApi { //<- telling which class we want to inject later
        return retrofit.create(FoodRecipesApi::class.java) //<-Specify the name of our api class
    }

}