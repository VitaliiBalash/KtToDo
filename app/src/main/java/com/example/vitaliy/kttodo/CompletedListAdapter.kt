package com.example.vitaliy.kttodo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.vitaliy.kttodo.states.ToDo

class CompletedViewHolder(view: View) : RecyclerView.ViewHolder(view), ViewHolderInterface {
    val viewDeleteBackground: RelativeLayout = view.findViewById(R.id.view_deleteBackground)
    val viewForeground: RelativeLayout = view.findViewById(R.id.view_foreground)
    val textToDo: TextView = view.findViewById(R.id.textView_todo)

    override fun getForeground() = viewForeground
    override fun getLeftBackground() = null
    override fun getRightBackground() = viewDeleteBackground
}

class CompletedListAdapter : RecyclerView.Adapter<CompletedViewHolder>() {
    var items: List<ToDo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        super.setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompletedViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.completed_list_item, parent, false)
        return CompletedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CompletedViewHolder, position: Int) {
        holder.textToDo.text = items[position].todo
    }

    override fun getItemCount(): Int = items.count()

    override fun getItemId(position: Int): Long = items[position].id
}
