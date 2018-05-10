package com.example.vitaliy.kttodo

import android.app.Application
import com.example.vitaliy.kttodo.reducers.appReducer
import tw.geothings.rekotlin.Store

val mainStore = Store(state = null, reducer = ::appReducer)

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        println("HI")
    }
}
