package com.example.reviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.review.testing.FakeReviewManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reviewTest()
    }

    private fun reviewTest(){
        Log.d("[DEBUG]","reviewTest")
//        val manager = ReviewManagerFactory.create(applicationContext)
        val manager = FakeReviewManager(applicationContext)
        val request = manager.requestReviewFlow()
        request.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                // We got the ReviewInfo object
                val reviewInfo = request.result
                Log.d("[DEBUG]","isSuccessful")
                Log.d("[DEBUG]",reviewInfo.toString())
            } else {
                // There was some problem, continue regardless of the result.
                Log.d("[DEBUG]","FALSE")
                Log.d("[DEBUG]", request.toString())
            }
        }

    }
}