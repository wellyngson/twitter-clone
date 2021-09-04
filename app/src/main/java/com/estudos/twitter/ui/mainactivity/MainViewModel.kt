package com.estudos.twitter.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudos.twitter.data.model.Tweet
import com.estudos.twitter.domain.UserUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private var mutableListTweet = MutableLiveData<List<Tweet>>()
    val listTweet: LiveData<List<Tweet>> = mutableListTweet

    fun init(searchTwitter: String) {
        getTweets(searchTwitter)
    }

    private fun getTweets(searchTwitter: String) {
        viewModelScope.launch {
            val responseListTweet = userUseCase.execute(searchTwitter)
            mutableListTweet.postValue(responseListTweet)
        }
    }
}
