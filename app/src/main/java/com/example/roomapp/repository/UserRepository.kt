package com.example.roomapp.repository

import androidx.lifecycle.LiveData
import com.example.roomapp.data.userDao
import com.example.roomapp.models.User

class UserRepository(private val userdao: userDao) {
    val readAlldata:LiveData<List<User>> = userdao.readAllData()

   suspend fun adduser(user: User){
         userdao.addUser(user)
    }
}