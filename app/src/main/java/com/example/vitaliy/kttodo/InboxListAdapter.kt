package com.example.vitaliy.kttodo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.example.vitaliy.kttodo.states.ToDo

class InboxViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val viewDeleteBackground: RelativeLayout = view.findViewById(R.id.view_delete_background)
    val viewDoneBackground: RelativeLayout = view.findViewById(R.id.view_done_background)
    val viewForeground: RelativeLayout = view.findViewById(R.id.view_foreground)
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
        println("Bind")
    }

    override fun getItemCount(): Int = items.count()

    override fun getItemId(position: Int): Long = items[position].uuid.mostSignificantBits
}
