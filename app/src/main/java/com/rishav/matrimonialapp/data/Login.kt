package com.rishav.matrimonialapp.data


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("md5")
    var md5: String? = null,
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("salt")
    var salt: String? = null,
    @SerializedName("sha1")
    var sha1: String? = null,
    @SerializedName("sha256")
    var sha256: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("uuid")
    var uuid: String? = null
)