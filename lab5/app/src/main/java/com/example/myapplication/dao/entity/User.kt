package com.example.myapplication.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "firstName") var firstName: String,
    @ColumnInfo(name = "lastName") var lastName: String,
    @ColumnInfo(name = "birthday") var birthday: String
) {
    constructor() : this(0, "", "","")
}