package com.tolerans.vitrinova.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiscoverItem(
    val categories: List<Category>,
    val collections: List<Collection>,
    val featured: List<Featured>,
    val products: List<Product>,
    val shops: List<Shop>,
    val title: String,
    val type: String
): Parcelable