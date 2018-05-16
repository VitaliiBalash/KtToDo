package com.example.vitaliy.kttodo

import android.app.Application
import com.example.vitaliy.kttodo.reducers.appReducer
import com.squareup.leakcanary.LeakCanary
import tw.geothings.rekotlin.Store

val mainStore = Store(state = null, reducer = ::appReducer)

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this);

        println("HI")
    }
}
