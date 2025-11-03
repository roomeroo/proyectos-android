package com.example.proyecto_final_android_apuntes.ui.navigation

import ListScreen
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavGraph(){
    val navController = rememberNavController();
    Scaffold(

    ) {
        innerPadding -> NavHost(
            navController = navController,
            startDestination = Destinations.TaskList.route
        ){
            val modificado: Modifier = Modifier.consumeWindowInsets(innerPadding).padding(innerPadding).padding(vertical = 8.dp, horizontal = 10.dp)

            composable<Destinations.TaskList>{
                ListScreen();
            }

        }
    }
}