package com.tolerans.vitrinova.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class İmage(
    val height: Int,
    val medium: Medium,
    val thumbnail: Thumbnail,
    val url: String,
    val width: Int
): Parcelable