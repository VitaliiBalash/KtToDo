package com.example.vitaliy.kttodo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.vitaliy.kttodo.actions.ToDoActionDelete
import com.example.vitaliy.kttodo.actions.ToDoActionDone
import com.example.vitaliy.kttodo.states.ToDoState
import tw.geothings.rekotlin.StoreSubscriber

class InboxActivity : AppCompatActivity(), StoreSubscriber<ToDoState>, RecyclerItemTouchHelperListener {

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

    override fun newState(state: ToDoState) {
        listAdapter.items = state.todoList.filter { !it.done }
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val id = viewHolder.itemId
        when(direction){
            ItemTouchHelper.LEFT -> mainStore.dispatch(ToDoActionDelete(id))
            ItemTouchHelper.RIGHT -> mainStore.dispatch(ToDoActionDone(id))
        }
    }
}
