package com.webservices.examen2dispo.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.webservices.examen2dispo.viewModel.BookViewModel
import com.webservices.domain.model.Book

@Composable
fun SearchBookScreen(viewModel: BookViewModel = hiltViewModel()) {
    val books by viewModel.books.observeAsState(emptyList())
    val loading by viewModel.loading.observeAsState(false)

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = viewModel.searchQuery,
            onValueChange = { viewModel.searchQuery = it },
            label = { Text("Buscar libro") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.searchBooks(viewModel.searchQuery) },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Buscar")
        }

        if (loading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(books) { book ->
                    BookItem(book = book)
                }
            }
        }
    }
}

@Composable
fun BookItem(book: Book) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = book.title, fontWeight = FontWeight.Bold)
            Text(text = "Autores: ${book.authors.joinToString()}")
            Text(text = "Año: ${book.year}")
        }
    }
}