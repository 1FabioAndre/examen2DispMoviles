package com.webservices.data.remote

import com.webservices.data.model.BookSearchResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {
    @GET("search.json")
    suspend fun searchBooks(@Query("q") query: String): BookSearchResponse
}