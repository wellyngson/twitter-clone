package com.estudos.twitter.domain.usecase

import com.estudos.twitter.data.model.DataTweet
import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.data.repository.UserRepository
import retrofit2.Response

class UserUseCase(
    private val repository: UserRepository
) {

    suspend fun execute(searchTwitter: String): Response<DataTweet> {
        return repository.getTwitterById(searchTwitter)
    }

    suspend fun executeUser(authorId: String): Response<DataUser> {
        return repository.getUserById(authorId)
    }
}