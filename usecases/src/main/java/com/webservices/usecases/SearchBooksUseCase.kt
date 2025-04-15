package com.webservices.usecases

import com.webservices.domain.repository.BookRepository
import com.webservices.domain.model.Book

class SearchBooksUseCase(
    private val repository: BookRepository
) {
    suspend operator fun invoke(query: String): List<Book> {
        return repository.searchBooks(query)
    }
}