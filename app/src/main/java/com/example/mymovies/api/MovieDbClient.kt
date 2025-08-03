package com.example.mymovies.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieDbClient {

    private const val baseUrl = "https://api.themoviedb.org/3/movie/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: MovieDbService = retrofit.create(MovieDbService::class.java)
}