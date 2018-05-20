package com.example.vitaliy.kttodo.actions

import com.example.vitaliy.kttodo.states.ToDo
import tw.geothings.rekotlin.Action

data class ToDoActionDelete(val id: Long) : Action

data class ToDoActionComplete(val id: Long) : Action

data class ToDoActionCreate(val todo: ToDo) : Action

data class ToDoActionReplace(val todos: List<ToDo>) : Action
