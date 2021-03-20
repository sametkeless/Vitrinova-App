package com.tolerans.vitrinova.util

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import com.tolerans.vitrinova.R

fun ImageView.setBlackFilter(){
   setColorFilter( Color.argb(100,0,0,0))
}
