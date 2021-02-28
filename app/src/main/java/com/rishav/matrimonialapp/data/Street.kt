package com.rishav.matrimonialapp.data


import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("number")
    var number: Int? = null
)