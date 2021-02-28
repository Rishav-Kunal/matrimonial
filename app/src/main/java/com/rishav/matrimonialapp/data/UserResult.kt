package com.rishav.matrimonialapp.data


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.rishav.matrimonialapp.util.ApplicationConstants

@Entity(tableName = "users_table")
data class UserResult(
    @SerializedName("cell")
    var cell: String? = null,
    @SerializedName("dob")
    @Embedded(prefix = "dob_")
    var dob: Dob? = null,
    @SerializedName("email")
    @PrimaryKey
    var email: String,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("id")
    @Embedded
    var id: Id? = null,
    @SerializedName("location")
    @Embedded(prefix = "location_")
    var location: Location? = null,
    @SerializedName("login")
    @Embedded(prefix = "login_")
    var login: Login? = null,
    @SerializedName("name")
    @Embedded(prefix = "name_")
    var name: Name? = null,
    @SerializedName("nat")
    var nat: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("picture")
    @Embedded(prefix = "picture_")
    var picture: Picture? = null,
    @SerializedName("registered")
    @Embedded(prefix = "registered_")
    var registered: Registered? = null,
    var userAction: Int = 0
)