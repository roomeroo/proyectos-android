package com.example.proyecto_final_android_apuntes.data.model

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val completed: Boolean = false,
)