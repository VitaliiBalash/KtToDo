package com.example.vitaliy.kttodo.reducers

import com.example.vitaliy.kttodo.states.AppState
import com.example.vitaliy.kttodo.states.ToDo
import com.example.vitaliy.kttodo.states.ToDoState
import tw.geothings.rekotlin.Action

fun appReducer(action: Action, oldState: AppState?): AppState {
    val state = oldState ?: initialAppState()
    return state.copy(
            todoState = (::todoReducer)(action, state.todoState)
    )
}

fun initialAppState() = AppState(
        todoState = ToDoState(
                todoList = listOf(
                        ToDo(id = 1, todo = "Task 1"),
                        ToDo(id = 2, todo = "Task 2"),
                        ToDo(id = 3, todo = "Task 3"),
                        ToDo(id = 4, todo = "Task 4"),
                        ToDo(id = 5, todo = "Task 5"),
                        ToDo(id = 6, todo = "Task 6"),
                        ToDo(id = 7, todo = "Task 7"),
                        ToDo(id = 8, todo = "Task 8"),
                        ToDo(id = 9, todo = "Task 9"),
                        ToDo(id = 10, todo = "Task 10"),
                        ToDo(id = 11, todo = "Task 11"),
                        ToDo(id = 12, todo = "Task 12"),
                        ToDo(id = 13, todo = "Task 13"),
                        ToDo(id = 14, todo = "Task 14"),
                        ToDo(id = 15, todo = "Task 15"),
                        ToDo(id = 16, todo = "Task 16"),
                        ToDo(id = 17, todo = "Task 17"),
                        ToDo(id = 18, todo = "Task 18"),
                        ToDo(id = 19, todo = "Task 19")
                )
        )
)
