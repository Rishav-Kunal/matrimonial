package com.rishav.matrimonialapp.data


import com.google.gson.annotations.SerializedName

data class Timezone(
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("offset")
    var offset: String? = null
)