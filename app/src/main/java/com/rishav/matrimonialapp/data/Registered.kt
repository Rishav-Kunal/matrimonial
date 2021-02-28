package com.rishav.matrimonialapp.data


import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("age")
    var age: Int? = null,
    @SerializedName("date")
    var date: String? = null
)