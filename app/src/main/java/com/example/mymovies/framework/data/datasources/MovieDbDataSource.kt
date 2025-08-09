package com.example.mymovies.framework.data.datasources

import com.example.mymovies.data.datasources.RemoteDataSource
import com.example.mymovies.data.datasources.MovieDb as ServerMovie
import com.example.mymovies.domain.Movie as DomainMovie

class MovieDbDataSource(
    private val client: MovieDbClient?
) : RemoteDataSource {
    override suspend fun getPopularMovies(apikey: String?, language: String?, region: String?): List<DomainMovie>? {
        val response = client?.service?.getPopularMoviesWithApiKey(
            apikey = apikey ?: "",
            language = language ?: "",
            region = region ?: ""
        )

        val result = response?.results

        val movies = result?.map { movie: ServerMovie ->
            DomainMovie(
                adult = movie.adult,
                backdropPath = movie.backdropPath,
                genreIds = movie.genreIds,
                id = movie.id,
                originalLanguage = movie.originalLanguage,
                originalTitle = movie.originalTitle,
                overview = movie.overview,
                popularity = movie.popularity,
                posterPath = movie.posterPath,
                releaseDate = movie.releaseDate,
                title = movie.title,
                video = movie.video,
                voteAverage = movie.voteAverage,
                voteCount = movie.voteCount
            )
        }

        return movies
    }

}