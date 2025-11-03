package com.turingalan.pokemon.ui

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.turingalan.pokemon.ui.list.TodoListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController();

    Scaffold {
        innerPadding -> NavHost(
        navController = navController,
        startDestination = Destinations.List.route
        ){
        val hostModifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding)
            composable<Destinations.List> {
                TodoListScreen(
                    modifier = hostModifier,
                    onNavigateToDetail = {
                        navController.navigate(Destinations.Details(it))
                    }
                )
            }
            composable<Destinations.Details>{

            }
        }
    }
}