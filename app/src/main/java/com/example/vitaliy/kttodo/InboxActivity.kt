package com.example.vitaliy.kttodo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.vitaliy.kttodo.states.ToDosState
import tw.geothings.rekotlin.StoreSubscriber

class InboxActivity : AppCompatActivity(), StoreSubscriber<ToDosState>, RecyclerItemTouchHelperListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var listAdapter: InboxListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inbox)

        listAdapter = InboxListAdapter(this)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = listAdapter

        val recyclerItemTouchHelper = RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT, this)
        ItemTouchHelper(recyclerItemTouchHelper).attachToRecyclerView(recyclerView)

        mainStore.subscribe(this) { it.select { it.todoState } }
    }

    override fun onDestroy() {
        mainStore.unsubscribe(this)
        super.onDestroy()
    }

    override fun newState(state: ToDosState) {
        listAdapter.items = state.todoList
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        println("swiped")
    }
}
