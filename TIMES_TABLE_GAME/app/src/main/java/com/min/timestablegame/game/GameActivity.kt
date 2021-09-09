package com.min.timestablegame.game

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.min.timestablegame.databinding.ActivityGameBinding
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {
    //    전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityGameBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    private var gameArrary:ArrayList<Int> = ArrayList<Int>()
    private var gameAnswerArrary:ArrayList<Int> = ArrayList<Int>()

    private var answerResult:Int = 0
    private var base:Int = 0
    private var count:Int = 0
    private lateinit var mHandler: Handler
    private lateinit var mRunnable:Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_option)

        gameArrary.add(7)

        base = gameArrary[0]
        mBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setAnswer()
//        setComplete()
        count = 1

        // Initialize the handler instance
        mHandler = Handler()

        answerMaker()
        checkAnswer()
    }

    private fun setGame() {
        answerResult =  base * count
        binding.problemText.text = base.toString()+"X"+ count.toString()
        binding.answer1.text = gameAnswerArrary[0].toString()
        binding.answer2.text = gameAnswerArrary[1].toString()
        binding.answer3.text = gameAnswerArrary[2].toString()
        binding.answer4.text = gameAnswerArrary[3].toString()
        binding.answer5.text = gameAnswerArrary[4].toString()
        binding.answer6.text = gameAnswerArrary[5].toString()
    }

    private fun answerMaker() {
        gameAnswerArrary = ArrayList<Int>()
        gameAnswerArrary.add(base * count)
        val random = Random()
//        val num = random.nextInt(5)

        while (gameAnswerArrary.size < 6){
            val num = random.nextInt(base * count)
            if(!gameAnswerArrary.contains(num)){
                gameAnswerArrary.add(num)
            }
        }
        // 섞는다.
        gameAnswerArrary.shuffle()
        Log.d("gameAnswerArrary",gameAnswerArrary.toString())
        setGame()
    }

    private fun checkAnswer() {
        binding.answer1.setOnClickListener(){
            setResultText(binding.answer1.text.toString())
        }
        binding.answer2.setOnClickListener(){
            setResultText(binding.answer2.text.toString())
        }
        binding.answer3.setOnClickListener(){
            setResultText(binding.answer3.text.toString())
        }
        binding.answer4.setOnClickListener(){
            setResultText(binding.answer4.text.toString())
        }
        binding.answer5.setOnClickListener(){
            setResultText(binding.answer5.text.toString())
        }
        binding.answer6.setOnClickListener(){
            setResultText(binding.answer6.text.toString())
        }
    }

    private fun setResultText(resultText:String) {
        binding.result.visibility = View.VISIBLE
        if((resultText) == answerResult.toString()){
            binding.result.setTextColor(Color.YELLOW)
            binding.result.text = "o"
        }else{
            binding.result.setTextColor(Color.RED)
            binding.result.text = "X"
        }
        Handler(Looper.getMainLooper()).postDelayed(
            { nextProblem() },
            1000 // value in milliseconds
        )
    }


    private fun nextProblem() {
        if(count < 9){
            count++
            binding.result.visibility = View.GONE
        }
        answerMaker()
    }

}