package com.example.vitaliy.kttodo

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import com.example.vitaliy.kttodo.actions.ToDoActionCreate
import com.example.vitaliy.kttodo.states.ToDo
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    val textInput_task: TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.textInput_task) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            mainStore.dispatch(ToDoActionCreate(
                    ToDo(todo = textInput_task.text.toString())
            ))
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
