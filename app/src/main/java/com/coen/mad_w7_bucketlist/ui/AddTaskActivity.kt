package com.coen.mad_w7_bucketlist.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.coen.mad_w7_bucketlist.R
import com.coen.mad_w7_bucketlist.db.TaskRepository
import com.coen.mad_w7_bucketlist.model.Task
import kotlinx.android.synthetic.main.activity_new_task.*

class AddTaskActivity : AppCompatActivity() {

    lateinit var repo: TaskRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        repo = TaskRepository(this)

        fab_submit.setOnClickListener {
            onSubmit()
        }
    }

    @SuppressLint("NewApi")
    private fun onSubmit() {
        val task = Task(
                et_title.text.toString(),
                et_description.text.toString(),
                false
        )

        repo.insert(task)
        finish()
    }
}