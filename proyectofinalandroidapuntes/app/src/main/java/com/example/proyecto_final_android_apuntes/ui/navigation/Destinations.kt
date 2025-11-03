package com.example.proyecto_final_android_apuntes.ui.navigation

sealed class Destinations(val route:String){
    object taskList: Destinations(route="list")
    data class taskDetail(val id: Int): Destinations(route = "detail/{id}")
}