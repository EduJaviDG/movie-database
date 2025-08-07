package com.example.mymovies.ui.activities.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.repositories.MovieRepository
import com.example.mymovies.domain.MovieDb
import com.example.mymovies.usecases.LoadPopularMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val movieRepository = MovieRepository()
    private val loadPopularMovies = LoadPopularMovies(repository = movieRepository)

    var apikey: String? = null
    var language: String? = null
    var region: String? = null

    private val _movies = MutableLiveData<List<MovieDb>>()
    val movies: LiveData<List<MovieDb>> get() = _movies

    fun getPopularMovies() {
        viewModelScope.launch {
            val response = loadPopularMovies.getPopularMovie(
                apikey = apikey,
                language = language,
                region = region
            )
            _movies.value = response.results
        }
    }
}