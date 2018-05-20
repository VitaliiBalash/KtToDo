package com.example.vitaliy.kttodo.db

import android.arch.persistence.room.*

@Entity(tableName = "todo")
data class ToDo(
        @PrimaryKey
        var id: Long,

        @ColumnInfo(name = "todo")
        var todo: String,

        @ColumnInfo(name = "completed")
        var completed: Boolean
) {
    @Ignore
    constructor(id: Long) : this(id, "", false)
}

@Dao
interface ToDoDao {
    @get:Query("SELECT * FROM todo")
    val all: List<ToDo>

    @Insert
    fun insert(todo: ToDo)

    @Delete
    fun delete(todo: ToDo)
}
