package com.webservices.data.model

import com.google.gson.annotations.SerializedName

data class BookSearchResponse(
    @SerializedName("docs") val books: List<BookDto>
)