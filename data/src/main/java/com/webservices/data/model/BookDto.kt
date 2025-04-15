package com.webservices.data.model

import com.google.gson.annotations.SerializedName

data class BookDto(
    @SerializedName("title") val title: String?,
    @SerializedName("author_name") val authors: List<String>?,
    @SerializedName("first_publish_year") val year: Int?
)