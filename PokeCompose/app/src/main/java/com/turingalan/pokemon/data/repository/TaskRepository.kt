package com.turingalan.pokemon.data.repository

import com.turingalan.pokemon.data.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(): TaskRepositoryInterface {

    val _tasks = mutableListOf<Task>(
        Task(id = 1, title = "buenos dias", description = "a"),
        Task(id = 2, title = "buenos dias", description = "a"),
        Task(id = 3, title = "buenos dias", description = "a"),
    )

    override suspend fun getAll(): List<Task> {
        return this._tasks;
    }

    override suspend fun getById(id: Int): Task? {
        return this._tasks.firstOrNull() { task ->  task.id == id }
    }

    override suspend fun addTask(task: Task) {
        if(!this._tasks.contains(task)){
            this._tasks.add(task)
        }
    }

    override suspend fun completeTask(id: Int) {
        this._tasks.firstOrNull() { it.id == id }?.completed = true;
    }

}