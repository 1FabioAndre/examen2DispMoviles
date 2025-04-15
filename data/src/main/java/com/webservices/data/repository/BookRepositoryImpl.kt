package com.webservices.data.repository

import com.webservices.domain.model.Book
import com.webservices.data.model.BookDto
import com.webservices.data.remote.BookApiService

class BookRepositoryImpl(
    private val api: BookApiService
) : BookRepository {
    override suspend fun searchBooks(query: String): List<Book> {
        return api.searchBooks(query).books.map {
            Book(
                title = it.title ?: "Sin título",
                authors = it.authors ?: listOf("Autor desconocido"),
                year = it.year ?: 0
            )
        }
    }
}