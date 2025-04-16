package com.webservices.examen2dispo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ExperimentalMaterial3Api


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteBooksScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Libros Favoritos") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Pantalla de favoritos")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                navController.popBackStack() // Vuelve a la anterior
            }) {
                Text("Volver a buscar")
            }
        }
    }
}