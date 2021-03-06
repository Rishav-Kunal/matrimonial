package com.rishav.matrimonialapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.rishav.matrimonialapp.data.RandomUserResponse
import com.rishav.matrimonialapp.data.UserResult
import com.rishav.matrimonialapp.database.UserDao
import com.rishav.matrimonialapp.network.NetworkApi
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject
const val TAG = "Repository"
class RandomUserRepositoryImpl @Inject constructor(private val api : NetworkApi, private val userDao: UserDao) : RandomUserRepository {
    override suspend fun fetchAllUsers() {
        try {
            val response = api.getMatches()
            if (response.isSuccessful){
                response.body()?.results?.let { saveAllUsers(it) }
            }
        } catch (e : UnknownHostException){
           Log.e(TAG,"Connectivity issues")
            //connectivity manager can be used to check the network state beforehand
        } catch (e : Exception){
            Log.e(TAG,"Some error in network operation")
        }
    }

    override suspend fun saveAllUsers(users: List<UserResult>) {
        userDao.insertAll(users)
    }

    override suspend fun updateUser(user: UserResult) {
        userDao.update(user)
    }

    override fun fetchAllUsersFromDb(): LiveData<List<UserResult>?> {
        return userDao.getNoActionUsers()
    }

    override fun fetchAcceptedUsersFromDb(): LiveData<List<UserResult>?> {
        return userDao.getAcceptedUsers()
    }

    override fun fetchDeclinedUsersFromDb(): LiveData<List<UserResult>?> {
        return userDao.getDeclinedUsers()
    }
}