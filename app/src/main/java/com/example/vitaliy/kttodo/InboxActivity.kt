package com.example.vitaliy.kttodo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vitaliy.kttodo.states.ToDosState
import tw.geothings.rekotlin.StoreSubscriber

class InboxActivity : AppCompatActivity(), StoreSubscriber<ToDosState> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inbox)

        mainStore.subscribe(this){it.select { it.todoState }}
    }

    override fun onDestroy() {
        mainStore.unsubscribe(this)
        super.onDestroy()
    }

    override fun newState(state: ToDosState) {

    }
}
