package com.rishav.matrimonialapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rishav.matrimonialapp.data.UserResult

@Database(entities = [UserResult::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao : UserDao
}