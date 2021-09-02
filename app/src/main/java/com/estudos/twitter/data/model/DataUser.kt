package com.estudos.twitter.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataUser(
    @SerializedName("data")
    val user: User
) : Serializable