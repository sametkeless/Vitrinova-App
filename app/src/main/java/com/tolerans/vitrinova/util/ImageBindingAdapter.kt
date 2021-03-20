package com.tolerans.vitrinova.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.tolerans.vitrinova.R

@BindingAdapter("imageUrl")
fun loadImage(imageView:ImageView,imageUrl:String?){
    if(!imageUrl.isNullOrEmpty())
        Picasso.get().load(imageUrl).into(imageView)
    else
        Picasso.get().load(R.drawable.ic_launcher_background).into(imageView)
}