package com.min.di_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print()
    }

    fun print(){
        Log.d("[DEBUG]","[JM]")
        print("[DEBUG]hi")
        println("[DEBUG]hi ln")
        print("[DEBUG]hi")
        println("[DEBUG]Hello, World!")
    }
}