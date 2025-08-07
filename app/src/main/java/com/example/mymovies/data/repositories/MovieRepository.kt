package com.example.mymovies.data.repositories
import com.example.mymovies.framework.data.datasources.api.MovieDbClient
class MovieRepository() {
    suspend fun getPopularMovie(apikey: String?, language: String?, region: String?) =
        MovieDbClient.service
            .getPopularMoviesWithApiKey(
                apikey = apikey ?: "",
                language = language ?: "",
                region = region ?: ""
            )
}