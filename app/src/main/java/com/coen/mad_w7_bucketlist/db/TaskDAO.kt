package com.coen.mad_w7_bucketlist.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.coen.mad_w7_bucketlist.model.Task

@Dao
interface TaskDAO {

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)

    @Query("DELETE FROM tasks")
    fun deleteAll()

    @Query("SELECT * from tasks")
    fun getAll(): LiveData<List<Task>>
}