package com.example.mvp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.R
import com.example.mvp.data.ImageItem
import com.example.mvp.util.ImageAsync


class ImageViewHolder(val context: Context, parent: ViewGroup?, private val listenerFunc: ((Int) -> Unit)?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)) {

    private val imageView by lazy {
        itemView.findViewById(R.id.img_view) as ImageView
    }

    private val textView by lazy {
        itemView.findViewById(R.id.text) as TextView
    }

    fun onBind(item: ImageItem, position: Int) {
        ImageAsync(context, imageView).execute(item.resource)
        textView.text = item.title

        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }
    }
}