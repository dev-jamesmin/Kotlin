package com.example.gradletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iambedant.librarya.ClassA
import com.iambedant.libraryb.ClassB
//import com.iambedant.libraryc.ClassC
import com.iambedant.libraryd.ClassD

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("B->:",getJokerFromB())
        Log.d("D->:",getJokerFromD())

        Log.d("A->:",getJokerFromA())
//        Log.d("C->:",getJokerFromC())

        getJokerFromB()
        getJokerFromD()

        getJokerFromA()
//        getJokerFromC()
    }

    private fun getJokerFromB():String{
        return ClassB().whereIsMyJoke()
    }

    private fun getJokerFromD():String{
        return ClassD().tellMeAJoke()
    }

    private fun getJokerFromA():String{
        return ClassA().whereIsMyJoke()
    }

//    private fun getJokerFromC():String{
//        return ClassC().tellMeAJoke()
//    }

}