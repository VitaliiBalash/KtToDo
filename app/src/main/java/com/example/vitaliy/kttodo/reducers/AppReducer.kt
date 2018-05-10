package com.example.vitaliy.kttodo.reducers

import com.example.vitaliy.kttodo.states.AppState
import com.example.vitaliy.kttodo.states.ToDo
import com.example.vitaliy.kttodo.states.ToDosState
import tw.geothings.rekotlin.Action
import java.util.*

fun appReducer(action: Action, oldState: AppState?): AppState {
    val state = oldState ?: initialAppState()
    return state.copy()
}

fun initialAppState() = AppState(
        todoState = ToDosState(
                todoList = listOf(
                        ToDo(uuid = UUID.randomUUID(), task = "Task 1"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 2"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 3"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 4"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 5"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 6"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 7"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 8"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 9"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 10"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 11"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 12"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 13"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 14"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 15"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 16"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 17"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 18"),
                        ToDo(uuid = UUID.randomUUID(), task = "Task 19")
                )
        )
)
