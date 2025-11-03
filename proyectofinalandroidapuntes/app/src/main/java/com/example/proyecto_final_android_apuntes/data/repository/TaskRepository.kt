package com.example.proyecto_final_android_apuntes.data.repository

import com.example.proyecto_final_android_apuntes.data.model.Task
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(): TaskRepositoryInterface{
    private val _tasks = mutableListOf<Task>(
        Task(1,"Primera tarea","nada"),
        Task(2, "Segunda tarea", "nada de nada", true)
    )

    override fun getAllTask(): List<Task> {
        return this._tasks;
    }

    override fun getTaskById(id: Int): Task? {
        return this._tasks.find { task -> task.id == id  }
    }

    override fun addTask(task: Task) {
        this._tasks.add(task)
    }

    override fun deleteTask(id: Int): Boolean {
        return this._tasks.removeIf { task -> task.id == id }
    }

    override fun completeTask(task: Task) {
        val pos = getPositionOf(task)
        if(pos != -1)
            this._tasks[pos] = task;
    }

    override fun uncompleteTask(task: Task) {
        val pos = getPositionOf(task)
        if(pos != -1)
            this._tasks[pos] = task;
    }

    private fun getPositionOf(task: Task): Int{
        return this._tasks.indexOfFirst { it.id == task.id }
    }

}