package com.example.roomapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomapp.models.User
import com.example.roomapp.data.UserDatabase
import com.example.roomapp.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application) {
     val readallData:LiveData<List<User>>
    private val repository: UserRepository
    init {
        val userdao = UserDatabase.getDatabase(application).userdao()
           repository = UserRepository(userdao)
        readallData = repository.readAlldata
    }

     fun adduser(user: User){
        viewModelScope.launch {  Dispatchers.IO
            repository.adduser(user)
        }

    }

}