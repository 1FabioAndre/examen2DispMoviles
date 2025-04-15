package com.webservices.usecases

class SearchBooksUseCase(
    private val repository: BookRepository
) {
    suspend operator fun invoke(query: String): List<Book> {
        return repository.searchBooks(query)
    }
}