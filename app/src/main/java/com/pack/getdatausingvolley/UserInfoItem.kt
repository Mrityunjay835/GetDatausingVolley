package com.pack.getdatausingvolley

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Userinfo_table")
data class UserInfoItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    val id:Int,
    @ColumnInfo(name="city")
    val city: String,
    @ColumnInfo(name="name")
    val name: String
)