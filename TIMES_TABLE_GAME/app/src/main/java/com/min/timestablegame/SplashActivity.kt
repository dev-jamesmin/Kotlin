package com.min.timestablegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import kotlin.concurrent.timer

//Splash
class SplashActivity : AppCompatActivity() {

    var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d("[BRANDI]START","")
        timer = timer(period = 10,initialDelay = 2000){
            print("[BRANDI]timer")
            Log.d("[BRANDI]timer","start")
            startMain()
        }
        Log.d("[BRANDI]timer","cancel")
        print("[BRANDI]timer - cancel")

    }

    private fun startMain(){
        Log.d("[BRANDI]startMain","CALL")
        print("[BRANDI]startMain")
        timer?.cancel()
//        finish()
        val intent = Intent(this,MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

}