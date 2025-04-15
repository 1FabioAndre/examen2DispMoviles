package com.webservices.framework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.webservices.data.remote.BookApiService
import com.webservices.domain.repository.BookRepository
import com.webservices.data.repository.BookRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBookRepository(api: BookApiService): BookRepository =
        BookRepositoryImpl(api)
}
