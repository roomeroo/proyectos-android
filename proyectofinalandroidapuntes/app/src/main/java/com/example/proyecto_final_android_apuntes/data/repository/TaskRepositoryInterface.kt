package com.example.proyecto_final_android_apuntes.data.repository

import com.example.proyecto_final_android_apuntes.data.model.Task

interface TaskRepositoryInterface{
    fun getAllTask(): List<Task>
    fun getTaskById(id: Int): Task?
    fun addTask(task: Task)
    fun deleteTask(id: Int): Boolean
    fun completeTask(id: Task)
    fun uncompleteTask(id: Task)
}