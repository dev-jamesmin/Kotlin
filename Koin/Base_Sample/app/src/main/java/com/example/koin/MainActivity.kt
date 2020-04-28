package com.example.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val myPresenter: MyPresenter by inject() // 이 부분을 통해서 의존성 주입이 일어납니다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("DEBUG", "onCreate")
        myTextView.text = myPresenter.sayHello()

    }
}
