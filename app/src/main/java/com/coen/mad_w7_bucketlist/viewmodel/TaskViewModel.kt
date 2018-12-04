package com.coen.mad_w7_bucketlist.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.coen.mad_w7_bucketlist.db.TaskRepository
import com.coen.mad_w7_bucketlist.model.Task

class TaskViewModel(context: Context)  : ViewModel()  {

    private var repo: TaskRepository = TaskRepository(context)

    companion object {
        lateinit var allTasks: LiveData<List<Task>>
    }

    init {
        allTasks = repo.getAll()
    }

    fun insert(g: Task) { repo.insert(g) }
}