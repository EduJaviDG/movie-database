package com.example.mymovies.framework.data.datasources.api

import com.example.mymovies.data.datasources.MovieDbResult
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface MovieDbService {

    @GET("popular")
    suspend fun getPopularMoviesWithApiKey(@Query("api_key") apikey: String,
                                           @Query("language") language: String,
                                           @Query("region") region: String): MovieDbResult

    @GET("popular")
    suspend fun getPopularMoviesWithAccessToken(@HeaderMap headers: Map<String,String>): MovieDbResult
}