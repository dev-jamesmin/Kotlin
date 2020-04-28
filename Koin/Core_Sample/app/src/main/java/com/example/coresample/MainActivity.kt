package com.example.coresample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.sample.HelloService

class MainActivity : AppCompatActivity() {

    // Inject HelloService
    private val helloService: HelloService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("DEBUG","onCreate->:"+helloService.hello())

        sayHello()
    }

    private fun sayHello()
    {
        Log.d("DEBUG","sayHello->:"+helloService.hello())
        text.text = helloService.hello()
        Log.d("DEBUG","RESULT->:"+helloService.hello())
        println(helloService.hello())
    }




    // display our data
//    private fun sayHello(): () -> Unit = {
//        text.text = helloService.hello()
//        Log.d("DEBUG","RESULT->:"+helloService.hello())
//        println(helloService.hello())
//    }
}
