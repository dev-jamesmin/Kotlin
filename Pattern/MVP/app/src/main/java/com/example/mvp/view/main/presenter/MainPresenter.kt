package com.example.mvp.view.main.presenter

import android.content.Context
import com.example.mvp.adapter.contract.ImageAdapterContract
import com.example.mvp.data.ImageItem
import com.example.mvp.data.source.image.SampleImageRepository
import com.example.mvp.data.source.image.SampleImageSource
import java.util.*


class MainPresenter : MainContract.Presenter {

    override lateinit var view: MainContract.View
    override lateinit var imageData: SampleImageRepository

    override lateinit var adapterModel: ImageAdapterContract.Model
    override var adapterView: ImageAdapterContract.View? = null
        set(value) {
            field = value
            field?.onClickFunc = { onClickListener(it) }
        }

    override fun loadItems(context: Context, isClear: Boolean) {
        imageData.getImages(context, 10, object : SampleImageSource.LoadImageCallback {
            override fun onLoadImages(list: ArrayList<ImageItem>) {
                if (isClear) {
                    adapterModel.clearItem()
                }

                adapterModel.addItems(list)
                adapterView?.notifyAdapter()
            }
        })
    }

    private fun onClickListener(position: Int) {
        adapterModel.getItem(position).let {
            view.showToast(it.title)
        }
    }
}