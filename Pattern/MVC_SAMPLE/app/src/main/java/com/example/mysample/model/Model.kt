package com.example.mysample.model

import java.util.*

class Model : Observable() {

    private var mList: ArrayList<Int>? = null


    fun addData() {
        mList = ArrayList<Int>()
        mList?.add(0)
        mList?.add(1)
    }


    fun getDataAtIndex(index: Int): Int {
        return mList?.get(index)!!
    }

    fun setDataAtIndex(index: Int) {
        mList?.set(index, (mList?.get(index) ?: 0) + 1);
        setChanged()
        notifyObservers()
    }
}
