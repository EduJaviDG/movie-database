package com.example.mymovies.framework.data.datasources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDbClient() {
    companion object{
        private const val baseUrl = "https://api.themoviedb.org/3/movie/"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: MovieDbService = retrofit.create(MovieDbService::class.java)
}