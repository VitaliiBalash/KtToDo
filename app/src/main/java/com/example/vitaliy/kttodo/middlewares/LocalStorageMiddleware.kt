package com.example.vitaliy.kttodo.middlewares

import com.example.vitaliy.kttodo.actions.*
import com.example.vitaliy.kttodo.states.AppState
import tw.geothings.rekotlin.Middleware

internal val localStorageMiddleware: Middleware<AppState> = { dispatch, getState ->
    { next ->
        { action ->
            when(action){
                is SyncActionLoad -> println("load")
                is ToDoActionCreate -> println("create")
                is ToDoActionComplete -> println("complete")
                is ToDoActionDelete -> println("delete")
            }

            next(action)
        }
    }
}