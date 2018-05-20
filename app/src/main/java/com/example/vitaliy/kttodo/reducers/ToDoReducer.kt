package com.example.vitaliy.kttodo.reducers

import com.example.vitaliy.kttodo.actions.*
import com.example.vitaliy.kttodo.states.ToDo
import com.example.vitaliy.kttodo.states.ToDoState
import tw.geothings.rekotlin.Action

fun todoReducer(action: Action, oldState: ToDoState): ToDoState {
    return when (action) {
        is ToDoActionDelete -> oldState.copy(
                todoList = oldState.todoList.filter { it.id != action.id }
        )

        is ToDoActionComplete -> oldState.copy(
                todoList = oldState.todoList.map {
                    if (it.id == action.id) it.copy(completed = true) else it
                }
        )

        is ToDoActionCreate -> oldState.copy(
                todoList = oldState.todoList + action.todo
        )

        is ToDoActionReplace -> oldState.copy(todoList = action.todos)

        else -> oldState
    }
}
