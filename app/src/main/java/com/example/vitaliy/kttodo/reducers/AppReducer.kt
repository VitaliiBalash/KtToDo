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
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 1"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 2"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 3"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 4"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 5"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 6"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 7"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 8"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 9"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 10"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 11"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 12"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 13"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 14"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 15"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 16"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 17"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 18"),
                        ToDo(uuid = UUID.randomUUID(), todo = "Task 19")
                )
        )
)
