package com.estudos.twitter.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.domain.UserUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val tweetMutableLiveData = MutableLiveData<DataTweet>()
    val tweetLiveDataTweet: LiveData<DataTweet> = tweetMutableLiveData

    fun init(searchTwitter: String) {
        getTweets(searchTwitter)
    }

    private fun getTweets(searchTwitter: String) {
        viewModelScope.launch {
            val response = userUseCase.execute(searchTwitter)
            tweetMutableLiveData.postValue(response)
        }
    }
}
