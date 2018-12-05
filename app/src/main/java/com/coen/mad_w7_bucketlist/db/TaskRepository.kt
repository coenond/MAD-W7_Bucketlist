package com.coen.mad_w7_bucketlist.db

import android.arch.lifecycle.LiveData
import android.content.Context
import com.coen.mad_w7_bucketlist.model.Task
import org.jetbrains.anko.doAsync

class TaskRepository(context: Context) {
    var taskDao: TaskDAO

    init {
        val taskDb = TaskDatabase.getDatabase(context)
        taskDao = taskDb!!.taskDao()
    }

    fun getAll(): LiveData<List<Task>> {
        return taskDao.getAll()
    }

    fun insert(task: Task) {
        doAsync { taskDao.insert(task) }
    }

    fun delete(task: Task) {
        doAsync { taskDao.delete(task) }
    }

    fun update(task: Task) {
        doAsync { taskDao.update(task) }
    }

    fun deleteAll() {
        doAsync { taskDao.deleteAll() }
    }
}