package com.estudos.twitter.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.domain.usecase.UserUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val useMutableLiveData = MutableLiveData<DataUser>()
    val useLiveData: LiveData<DataUser> = useMutableLiveData

    fun getUser(authorId: String) {
        viewModelScope.launch {
            val response = userUseCase.executeUser(authorId)
            useMutableLiveData.postValue(response.body())
        }
    }
}