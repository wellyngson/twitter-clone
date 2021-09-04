package com.estudos.twitter.domain

import com.estudos.twitter.data.model.DataUser
import com.estudos.twitter.data.model.Tweet
import com.estudos.twitter.data.repository.UserRepository

class UserUseCase(
    private val repository: UserRepository
) {

    suspend fun execute(searchTwitter: String): List<Tweet> {
        return repository.getTwitterById(searchTwitter)
    }

    suspend fun executeUser(authorId: String): DataUser {
        return repository.getUserById(authorId)
    }
}