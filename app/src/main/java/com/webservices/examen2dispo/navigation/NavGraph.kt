package com.webservices.examen2dispo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.webservices.examen2dispo.ui.screens.FavoriteBooksScreen
import com.webservices.examen2dispo.ui.screens.SearchBookScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "search") {

        composable("search") {
            SearchBookScreen(navController = navController)
        }

        composable("favorites") {
            FavoriteBooksScreen(navController = navController)
        }
    }
}