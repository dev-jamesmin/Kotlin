package com.min.timestablegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.min.timestablegame.databinding.ActivityMainBinding
import com.min.timestablegame.game.GameActivity
import com.min.timestablegame.option.OptionActivity

class MainActivity : AppCompatActivity() {

//    전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setButtons()
    }

    private fun setButtons() {
        binding.gameStart.setOnClickListener(){
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }

        binding.gameOption.setOnClickListener(){
            val intent = Intent(this,OptionActivity::class.java)
            startActivity(intent)
        }

    }


//    OptionActivity

//    override fun onBackPressed() {
////        super.onBackPressed()
//        // 메인에서 뒤로 가기 하면 종료.
//        finish()
//
//    }
}