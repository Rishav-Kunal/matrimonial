package com.rishav.matrimonialapp.data


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: Int? = null,
    @SerializedName("seed")
    var seed: String? = null,
    @SerializedName("version")
    var version: String? = null
)