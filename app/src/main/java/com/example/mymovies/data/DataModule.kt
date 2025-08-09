package com.example.mymovies.data

import com.example.mymovies.data.repositories.MovieRepository
import com.example.mymovies.framework.data.datasources.MovieDbClient
import com.example.mymovies.framework.data.datasources.MovieDbDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun movieRepositoryProvider(movieDbDataSource: MovieDbDataSource): MovieRepository =
        MovieRepository(movieDbDataSource)

}