package com.example.mymovies.data.datasources

import com.google.gson.annotations.SerializedName

data class MovieDbResult(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: List<MovieDb>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
)