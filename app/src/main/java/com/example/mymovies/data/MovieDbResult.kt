package com.example.mymovies.data

import com.example.mymovies.data.MovieDb
import com.google.gson.annotations.SerializedName

data class MovieDbResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDb>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)