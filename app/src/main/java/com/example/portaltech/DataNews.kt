package com.example.portaltech

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Parcelize
data class DataNews(
    val id: Int?,
    val image: String?,
    val title: String,
    val tanggal: String,
    val news: String,
): Parcelable {
    companion object{
        const val ID = "id"
        const val TABLE_NEWS = "table_news"
        const val TITLE = "title"
        const val TANGGAL = "tanggal"
        const val NEWS = "news"
        const val IMAGE = "image"
    }
}
