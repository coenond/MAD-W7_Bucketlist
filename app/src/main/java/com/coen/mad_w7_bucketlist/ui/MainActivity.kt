package com.coen.mad_w7_bucketlist.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.coen.mad_w7_bucketlist.R
import com.coen.mad_w7_bucketlist.base.BaseActivity
import com.coen.mad_w7_bucketlist.databinding.ActivityMainBinding
import com.coen.mad_w7_bucketlist.db.TaskRepository
import com.coen.mad_w7_bucketlist.model.Task
import com.coen.mad_w7_bucketlist.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, TaskViewModel>() {

    private lateinit var taskList: LiveData<List<Task>>
    private val taskAdapter = TaskAdapter { if (it != null) onTaskClick(it) }
    private lateinit var repo: TaskRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init RecyclerView
        rv_task_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_task_list.adapter = taskAdapter

        viewModel.taskList.observe(this, Observer {
            taskAdapter.update(it as ArrayList<Task>)
        })

        fab.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onTaskClick(task: Task) {
//        val intent = Intent(this, EditGameActivity::class.java)
//        intent.putExtra("task", task)
//        startActivity(intent)
        println("ontaskclick");
    }

    override fun getVMClass(): Class<TaskViewModel> = TaskViewModel::class.java
    override fun initVMBinding() { binding.viewmodel = viewModel }
    override fun getLayoutId(): Int = R.layout.activity_main
}
