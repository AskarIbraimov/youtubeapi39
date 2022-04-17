package com.example.youtubeapi39.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide.with(context)
        .load(url)
        .into(this)
}