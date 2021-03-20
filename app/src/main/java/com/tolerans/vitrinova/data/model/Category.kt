package com.tolerans.vitrinova.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val children: List<Children>,
    val cover: Cover,
    val id: Int,
    val logo: Logo,
    val name: String,
    val order: Int,
    val parent_category: ParentCategory?,
    val parent_id: Int?
):Parcelable