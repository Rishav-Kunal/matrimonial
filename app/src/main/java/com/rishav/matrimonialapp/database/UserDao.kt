package com.rishav.matrimonialapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rishav.matrimonialapp.data.UserResult

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: UserResult)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(userList: List<UserResult>)

    @Update
    suspend fun update(user: UserResult)

    @Delete
    suspend fun delete(user: UserResult)

    @Query("SELECT * FROM users_table")
    fun getUsers(): LiveData<List<UserResult>?>
}