package com.example.proyecto_final_android_apuntes.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class Destinations(val route:String){
    @Serializable
    object TaskList: Destinations(route="list")
    @Serializable
    data class TaskDetail(val id: Int): Destinations(route = "detail/{id}")
}