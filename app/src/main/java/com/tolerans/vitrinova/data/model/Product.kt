package com.tolerans.vitrinova.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val cargo_time: Int,
    val category: Category,
    val category_id: Int,
    val comment_count: Int,
    val commission_rate: Int,
    val definition: String,
    val difference: String,
    val id: Int,
    val images: List<İmage>,
    val is_active: Boolean,
    val is_approved: Boolean,
    val is_cargo_free: Boolean,
    val is_editor_choice: Boolean,
    val is_liked: Boolean,
    val is_new: Boolean,
    val is_owner: Boolean,
    val like_count: Int,
    val old_price: Int,
    val price: Int,
    val share_url: String,
    val shop: Shop,
    val slug: String,
    val stock: Int,
    val title: String
): Parcelable