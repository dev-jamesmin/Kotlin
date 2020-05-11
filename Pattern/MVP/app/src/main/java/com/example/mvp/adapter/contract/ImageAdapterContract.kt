package com.example.mvp.adapter.contract

import com.example.mvp.data.ImageItem
import java.util.*



interface ImageAdapterContract {

    interface View {

        var onClickFunc : ((Int) -> Unit)?

        fun notifyAdapter()
    }

    interface Model {

        fun addItems(imageItems: ArrayList<ImageItem>)

        fun clearItem()

        fun getItem(position: Int): ImageItem
    }
}