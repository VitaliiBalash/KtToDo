package com.example.vitaliy.kttodo.db

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import com.example.vitaliy.kttodo.App

@Database(entities = [ToDo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao

    companion object {
        val instance: AppDatabase by lazy {
            Room.databaseBuilder(App.instance.applicationContext,
                    AppDatabase::class.java, "todo.db")
                    .allowMainThreadQueries()
                    .build()
        }
    }
}
