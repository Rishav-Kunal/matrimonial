package com.rishav.matrimonialapp.data


import com.google.gson.annotations.SerializedName

data class RandomUserResponse(
    @SerializedName("info")
    var info: Info? = null,
    @SerializedName("results")
    var results: List<UserResult>? = null
)