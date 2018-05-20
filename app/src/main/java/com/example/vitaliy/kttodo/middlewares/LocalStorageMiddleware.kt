package com.example.vitaliy.kttodo.middlewares

import com.example.vitaliy.kttodo.actions.*
import com.example.vitaliy.kttodo.db.AppDatabase
import com.example.vitaliy.kttodo.db.ToDo
import com.example.vitaliy.kttodo.states.AppState
import tw.geothings.rekotlin.DispatchFunction
import tw.geothings.rekotlin.Middleware

internal val localStorageMiddleware: Middleware<AppState> = { dispatch, getState ->
    { next ->
        { action ->
            when (action) {
                is SyncActionLoad -> loadToDos(dispatch)
                is ToDoActionCreate -> createToDo(action)
                is ToDoActionComplete -> println("complete")
                is ToDoActionDelete -> deleteToDo(action)
            }

            next(action)
        }
    }
}

fun loadToDos(dispatch: DispatchFunction) {
    val todoDao = AppDatabase.instance.todoDao()
    val todos = todoDao.all.map {
        com.example.vitaliy.kttodo.states.ToDo(id = it.id, todo = it.todo, completed = it.completed)
    }
    dispatch(ToDoActionReplace(todos = todos))
}

fun createToDo(action: ToDoActionCreate) {
    val todoDao = AppDatabase.instance.todoDao()
    todoDao.insert(ToDo(
            id = action.todo.id,
            todo = action.todo.todo,
            completed = action.todo.completed
    ))
}

fun deleteToDo(action: ToDoActionDelete) {
    val todoDao = AppDatabase.instance.todoDao()
    todoDao.delete(ToDo(id = action.id))
}
