package com.example.youtubeparcer.core.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(image:String){
    Glide.with(this).load(image).into(this)
}