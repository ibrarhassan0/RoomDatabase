package com.example.roomdatabase.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application) {

    val alluser: LiveData<List<User>>
   var repository:UserRepository

    init {
        val dao=UserDatabase.getDatabase(application).UserDao()
        repository=UserRepository(dao)
        alluser=repository.alldata
    }

   fun deleteUser(user:User)= viewModelScope.launch(Dispatchers.IO) {
        repository.deleteUser(user)
    }

    fun insertUser(user: User)= viewModelScope.launch(Dispatchers.IO) {
        repository.insertUser(user)
    }
}