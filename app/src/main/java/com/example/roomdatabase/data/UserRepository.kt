package com.example.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao){

    val alldata:LiveData<List<User>> = userDao.getAllUser()

     fun insertUser(user: User){
        userDao.insertUser(user)
    }

     fun deleteUser(user: User){
        userDao.deleteUSer(user)
    }
}