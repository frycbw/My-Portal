package com.example.portaltech

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Parcelize
data class DataUser(
    val name: String,
    val username: String?,
    val password: String
): Parcelable{
    companion object{
        const val TABLE_USER = "table_user"
        const val NAME = "name"
        const val USERNAME = "username"
        const val PASSWORD= "password"
    }
}

