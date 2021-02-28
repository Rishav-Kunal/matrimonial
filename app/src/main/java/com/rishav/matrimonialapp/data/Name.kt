package com.rishav.matrimonialapp.data


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("first")
    var first: String? = null,
    @SerializedName("last")
    var last: String? = null,
    @SerializedName("title")
    var title: String? = null
)