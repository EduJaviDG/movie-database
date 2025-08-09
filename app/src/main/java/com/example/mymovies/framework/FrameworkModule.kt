package com.example.mymovies.framework

import com.example.mymovies.framework.data.datasources.MovieDbClient
import com.example.mymovies.framework.data.datasources.MovieDbDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {
    @Provides
    fun movieDbClientProvider(): MovieDbClient = MovieDbClient()

    @Provides
    fun movieDbDataSourceProvider(movieDbClient: MovieDbClient): MovieDbDataSource =
        MovieDbDataSource(movieDbClient)

}