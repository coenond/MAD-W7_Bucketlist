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

    fun insert(g: Task) {
        doAsync { taskDao.insert(g) }
    }


    fun delete(g: Task) {
        doAsync { taskDao.delete(g) }
    }

    fun update(g: Task) {
        doAsync { taskDao.update(g) }
    }

    fun deleteAll() {
        doAsync { taskDao.deleteAll() }
    }
}