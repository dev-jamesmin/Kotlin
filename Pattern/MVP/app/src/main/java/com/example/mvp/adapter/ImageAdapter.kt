package com.example.mvp.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.adapter.contract.ImageAdapterContract
import com.example.mvp.data.ImageItem
import java.util.*


class ImageAdapter(val context: Context) : ImageAdapterContract.View,
    RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.Model {

    private lateinit var imageList: ArrayList<ImageItem>

    override var onClickFunc: ((Int) -> Unit)? = null

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        imageList[position].let {
            holder?.onBind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(context, parent, onClickFunc)


    override fun getItemCount() = imageList.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun getItem(position: Int) = imageList[position]

    override fun addItems(imageItems: ArrayList<ImageItem>) {
        this.imageList = imageItems
    }

    override fun clearItem() {
        imageList.clear()
    }


}