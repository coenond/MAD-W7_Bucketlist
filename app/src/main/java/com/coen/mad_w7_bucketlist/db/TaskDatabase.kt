package com.coen.mad_w7_bucketlist.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.coen.mad_w7_bucketlist.model.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDAO

    /**
     * Use companion object to make methods public.
     */
    companion object {
        @Volatile
        var taskDatabaseInstance: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase? {
            if (taskDatabaseInstance == null) {
                synchronized(TaskDatabase::class.java) {
                    if (taskDatabaseInstance == null) {
                        taskDatabaseInstance = Room.databaseBuilder(
                                context.applicationContext,
                                TaskDatabase::class.java, "tasks_database")
                                .build()
                    }
                }
            }

            return taskDatabaseInstance
        }
    }
}