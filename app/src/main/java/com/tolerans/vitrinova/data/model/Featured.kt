package com.tolerans.vitrinova.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Featured(
    val cover: Cover,
    val id: Int,
    val sub_title: String,
    val title: String,
    val type: String
): Parcelable