package com.example.vitaliy.kttodo.states

import tw.geothings.rekotlin.StateType

data class ToDoState(
        val todoList: List<ToDo>
) : StateType

data class ToDo(
        val id: Long = System.currentTimeMillis(),
        val todo: String = "ToDo",
        val completed: Boolean = false
)
