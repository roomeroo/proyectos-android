package com.turingalan.pokemon.data.repository

import com.turingalan.pokemon.data.model.Task


interface TaskRepositoryInterface {
    suspend fun getAll(): List<Task>
    suspend fun getById(id:Int): Task?
    suspend fun addTask(task: Task)
    suspend fun completeTask(id: Int)
}