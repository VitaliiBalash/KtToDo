package com.example.vitaliy.kttodo

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vitaliy.kttodo.actions.ToDoActionComplete
import com.example.vitaliy.kttodo.actions.ToDoActionDelete
import com.example.vitaliy.kttodo.states.ToDoState
import tw.geothings.rekotlin.StoreSubscriber

/**
 * A placeholder fragment containing a simple view.
 */
class InboxFragment : Fragment(), StoreSubscriber<ToDoState>, RecyclerItemTouchHelperListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_inbox, container, false)

        listAdapter = InboxListAdapter()

        val layoutManager = LinearLayoutManager(activity)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = listAdapter

        val recyclerItemTouchHelper = RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT, this)
        ItemTouchHelper(recyclerItemTouchHelper).attachToRecyclerView(recyclerView)

        mainStore.subscribe(this) { it.select { it.todoState } }

        return view
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var listAdapter: InboxListAdapter

    override fun onDestroyView() {
        mainStore.unsubscribe(this)
        super.onDestroyView()
    }

    override fun newState(state: ToDoState) {
        listAdapter.items = state.todoList.filter { !it.completed }
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val id = viewHolder.itemId
        when(direction){
            ItemTouchHelper.LEFT -> mainStore.dispatch(ToDoActionDelete(id))
            ItemTouchHelper.RIGHT -> mainStore.dispatch(ToDoActionComplete(id))
        }
    }
}
