package com.example.roomdatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "User")
class User(@ColumnInfo(name="userText")val text:String){

    @PrimaryKey(autoGenerate = true)
    var id =0
}