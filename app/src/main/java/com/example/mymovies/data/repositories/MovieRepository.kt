package com.example.mymovies.data.repositories
import com.example.mymovies.framework.data.datasources.MovieDbClient
import com.example.mymovies.framework.data.datasources.MovieDbDataSource
import javax.inject.Inject

class MovieRepository @Inject constructor (private val movieDbDataSource: MovieDbDataSource) {
    suspend fun getPopularMovie(apikey: String?, language: String?, region: String?) =
        movieDbDataSource.getPopularMovies(
                apikey = apikey ?: "",
                language = language ?: "",
                region = region ?: ""
            )
}