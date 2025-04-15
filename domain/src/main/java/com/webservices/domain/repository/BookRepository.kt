package com.webservices.domain.repository

import com.webservices.domain.model.Book

interface BookRepository {
    suspend fun searchBooks(query: String): List<Book>
}