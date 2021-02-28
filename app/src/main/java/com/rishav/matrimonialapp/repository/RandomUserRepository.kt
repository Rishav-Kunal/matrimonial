package com.rishav.matrimonialapp.repository

import androidx.lifecycle.LiveData
import com.rishav.matrimonialapp.data.RandomUserResponse
import com.rishav.matrimonialapp.data.UserResult

interface RandomUserRepository {
    suspend fun fetchAllUsers()
    suspend fun saveAllUsers(users : List<UserResult>)
    suspend fun updateUser(user : UserResult)
    fun fetchAllUsersFromDb(): LiveData<List<UserResult>?>
}