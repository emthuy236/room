package com.example.roomapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomapp.models.User

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userdao(): userDao

    companion object{
        @Volatile
        private var INSTANCE:UserDatabase? = null

        fun getDatabase(context: Context):UserDatabase{
            val itemInstance = INSTANCE
            if (itemInstance != null){
                return itemInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,UserDatabase::class.java,"user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}