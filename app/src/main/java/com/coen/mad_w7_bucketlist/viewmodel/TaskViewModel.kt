package com.coen.mad_w7_bucketlist.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.coen.mad_w7_bucketlist.db.TaskRepository
import com.coen.mad_w7_bucketlist.model.Task

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    val taskList: LiveData<List<Task>>
    private val taskRepository = TaskRepository(application.applicationContext)

    init {
        taskList = taskRepository.getAll()
    }

    fun removeTask(task: Task) {
        taskRepository.delete(task)
    }

    fun updateTask(task: Task) {
        taskRepository.update(task)
    }
}