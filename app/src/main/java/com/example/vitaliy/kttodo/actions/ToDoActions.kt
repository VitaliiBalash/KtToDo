package com.example.vitaliy.kttodo.actions

import tw.geothings.rekotlin.Action

data class ToDoActionDelete(val id: Long) : Action

data class ToDoActionDone(val id: Long) : Action
