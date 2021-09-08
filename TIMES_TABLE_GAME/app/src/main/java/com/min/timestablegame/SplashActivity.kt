package com.min.timestablegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.*
import kotlin.concurrent.timer

class SplashActivity : AppCompatActivity() {

    var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        print("[BRANDI]START")
        timer = timer(period = 10,initialDelay = 3000){
            print("[BRANDI]timer")
            startMain()
        }

        print("[BRANDI]timer - cancel")

    }

    private fun startMain(){
        print("[BRANDI]startMain")
        timer?.cancel()

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}