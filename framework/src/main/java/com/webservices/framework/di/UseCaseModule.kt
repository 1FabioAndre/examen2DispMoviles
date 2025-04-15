package com.webservices.framework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.webservices.domain.repository.BookRepository
import com.webservices.usecases.SearchBooksUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSearchBooksUseCase(repo: BookRepository): SearchBooksUseCase =
        SearchBooksUseCase(repo)
}