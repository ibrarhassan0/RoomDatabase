package com.example.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase(): RoomDatabase() {

    abstract fun UserDao(): UserDao

    companion object{
        private var INSTANCE:UserDatabase?=null

      fun getDatabase(context: Context):UserDatabase{

          return INSTANCE?: synchronized(this){
              val instance=Room.databaseBuilder(context,
                  UserDatabase::class.java,"User_Database").build()
              INSTANCE=instance
              instance
          }
      }
    }}