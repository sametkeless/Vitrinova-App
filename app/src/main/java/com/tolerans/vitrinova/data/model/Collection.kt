package com.tolerans.vitrinova.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Collection(
    val cover: Cover,
    val definition: String,
    val id: Int,
    val logo: Logo,
    val share_url: String,
    val start: String,
    val title: String
): Parcelable