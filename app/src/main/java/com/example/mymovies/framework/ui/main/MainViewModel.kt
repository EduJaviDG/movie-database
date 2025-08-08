package com.example.mymovies.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.data.datasources.MovieDb
import com.example.mymovies.usecases.LoadPopularMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val loadPopularMovies: LoadPopularMovies) : ViewModel() {
    //private val loadPopularMovies = LoadPopularMovies(repository = movieRepository)

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