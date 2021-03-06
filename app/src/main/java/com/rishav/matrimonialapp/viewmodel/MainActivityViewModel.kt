package com.rishav.matrimonialapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishav.matrimonialapp.data.UserResult
import com.rishav.matrimonialapp.repository.RandomUserRepository
import com.rishav.matrimonialapp.util.ApplicationConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RandomUserRepository): ViewModel() {

    val userLiveData : LiveData<List<UserResult>?> = repository.fetchAllUsersFromDb()
    val acceptedUserLiveData : LiveData<List<UserResult>?> = repository.fetchAcceptedUsersFromDb()
    val declinedUserLiveData : LiveData<List<UserResult>?> = repository.fetchDeclinedUsersFromDb()

    val isLoading : LiveData<Boolean> get() = _isLoading
    private val _isLoading : MutableLiveData<Boolean> = MutableLiveData(true)

    init {
        getAllUsers()
    }

    private fun getAllUsers() = viewModelScope.launch {
        _isLoading.postValue(true)
        repository.fetchAllUsers()
        _isLoading.postValue(false)
    }
    fun applyUserAction(userResult: UserResult, accepted : Boolean) = viewModelScope.launch{
        if (accepted) {
            userResult.userAction = ApplicationConstants.USER_ACTION_ACCEPTED
        } else{
            userResult.userAction = ApplicationConstants.USER_ACTION_DECLINED
        }
        repository.updateUser(userResult)
    }

}