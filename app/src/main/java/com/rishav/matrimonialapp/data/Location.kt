package com.rishav.matrimonialapp.data


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("coordinates")
    @Embedded
    var coordinates: Coordinates? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("postcode")
    var postcode: String? = null,
    @SerializedName("state")
    var state: String? = null,
    @SerializedName("street")
    @Embedded
    var street: Street? = null,
    @SerializedName("timezone")
    @Embedded
    var timezone: Timezone? = null
)