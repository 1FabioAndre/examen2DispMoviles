package com.webservices.examen2dispo.ui.screens

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