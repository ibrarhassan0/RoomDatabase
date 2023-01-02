package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
   fun insertUser(user: User)

    @Delete
    fun deleteUSer(user: User):Void

    @Query("Select * FROM User order by id")
    fun getAllUser(): LiveData<List<User>>

}