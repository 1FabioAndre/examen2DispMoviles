package com.webservices.domain.model

data class Book(
    val title: String,
    val authors: List<String>,
    val year: Int
)