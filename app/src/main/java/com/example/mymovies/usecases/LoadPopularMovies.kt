package com.example.mymovies.usecases

import com.example.mymovies.data.repositories.MovieRepository

class LoadPopularMovies(private val repository: MovieRepository) {
    suspend fun getPopularMovie(apikey: String?, language: String?, region: String?) =
        repository.getPopularMovie(apikey = apikey, language = language, region = region)

}