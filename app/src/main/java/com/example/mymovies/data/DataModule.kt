package com.example.mymovies.data

import com.example.mymovies.data.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun movieRepositoryProvider() = MovieRepository()

}