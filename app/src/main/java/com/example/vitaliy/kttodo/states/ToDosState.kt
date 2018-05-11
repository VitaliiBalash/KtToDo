package com.example.vitaliy.kttodo.states

import tw.geothings.rekotlin.StateType
import java.util.*

data class ToDosState(
        val todoList: List<ToDo>
) : StateType

data class ToDo(
        val uuid: UUID,
        val todo: String
)
