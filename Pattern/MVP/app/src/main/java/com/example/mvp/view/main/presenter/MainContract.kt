package com.example.mvp.view.main.presenter

import android.content.Context
import com.example.mvp.adapter.contract.ImageAdapterContract
import com.example.mvp.data.source.image.SampleImageRepository

interface MainContract {

    interface View {

        fun showToast(title: String)
    }

    interface Presenter {
        var view: MainContract.View
        var imageData: SampleImageRepository

        var adapterModel: ImageAdapterContract.Model
        var adapterView: ImageAdapterContract.View?

        fun loadItems(context: Context, isClear: Boolean)
    }
}