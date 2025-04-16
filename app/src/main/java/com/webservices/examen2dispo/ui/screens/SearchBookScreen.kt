package com.webservices.examen2dispo.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.webservices.examen2dispo.ui.BookViewModel
import com.webservices.domain.model.Book

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController


@Composable
fun SearchBookScreen(navController: NavController, viewModel: BookViewModel = hiltViewModel()) {
    val books by viewModel.books.observeAsState(emptyList())
    val loading by viewModel.loading.observeAsState(false)

    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar libro") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.searchBooks(searchQuery)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
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