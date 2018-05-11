package com.example.vitaliy.kttodo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.vitaliy.kttodo.states.ToDo

class InboxViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val viewDeleteBackground: RelativeLayout = view.findViewById(R.id.view_deleteBackground)
    val viewDoneBackground: RelativeLayout = view.findViewById(R.id.view_doneBackground)
    val viewForeground: RelativeLayout = view.findViewById(R.id.view_foreground)
    val textToDo: TextView = view.findViewById(R.id.textView_todo)
}

class InboxListAdapter(private val context: Context) : RecyclerView.Adapter<InboxViewHolder>() {
    var items: List<ToDo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        super.setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.inbox_list_item, parent, false)
        return InboxViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InboxViewHolder, position: Int) {
        holder.textToDo.text = items[position].todo
    }

    override fun getItemCount(): Int = items.count()

    override fun getItemId(position: Int): Long = items[position].id
}
