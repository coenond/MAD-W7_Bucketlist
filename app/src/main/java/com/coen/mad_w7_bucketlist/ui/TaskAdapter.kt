package com.coen.mad_w7_bucketlist.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coen.mad_w7_bucketlist.R
import com.coen.mad_w7_bucketlist.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(private val onClickCallback: (Task?) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    private var items: List<Task>? = null
    private lateinit var context: Context

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            tvTitle.text = items?.get(position)?.title
            tvDescription.text = items?.get(position)?.description
        }
    }

    fun update(items : ArrayList<Task>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Task? {
        return items?.get(position)
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle = view.tv_title
    val tvDescription = view.tv_description
    val checkbox = view.checkbox
}