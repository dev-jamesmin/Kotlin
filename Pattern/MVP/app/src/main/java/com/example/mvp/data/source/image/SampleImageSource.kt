package com.example.mvp.data.source.image

import android.content.Context
import com.example.mvp.data.ImageItem
import java.util.*

interface SampleImageSource {

    interface LoadImageCallback {

        fun onLoadImages(list: ArrayList<ImageItem>)
    }

    fun getImages(context: Context, size: Int, loadImageCallback: LoadImageCallback?)
}