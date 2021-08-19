package com.estudos.twitter.data.model

import com.google.gson.annotations.SerializedName

data class DataUser(
    @SerializedName("data")
    val user: User
)