package com.webservices.framework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.webservices.domain.repository.BookRepository
import com.webservices.usecases.SearchBooksUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideSearchBooksUseCase(repo: BookRepository): SearchBooksUseCase =
        SearchBooksUseCase(repo)
}