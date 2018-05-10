package com.example.vitaliy.kttodo.states

import tw.geothings.rekotlin.StateType

data class AppState(
        val todoState: ToDosState
) : StateType
