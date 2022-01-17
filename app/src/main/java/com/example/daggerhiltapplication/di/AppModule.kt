package com.example.daggerhiltapplication.di

import com.example.daggerhiltapplication.network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseUrl():String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(baseurl:String):Retrofit =
        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideApiPostService(retrofit: Retrofit) : PostApiService =
        retrofit.create(PostApiService::class.java)
}