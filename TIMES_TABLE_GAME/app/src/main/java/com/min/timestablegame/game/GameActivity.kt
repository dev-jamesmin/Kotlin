package com.min.timestablegame.game

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.min.timestablegame.common.CommonValue
import com.min.timestablegame.databinding.ActivityGameBinding
import com.min.timestablegame.util.RandomUtil
import com.min.timestablegame.util.SharedPreferencesUtil
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {
    //    전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityGameBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

//    private var gameArrary:ArrayList<Int> = ArrayList<Int>()
    private var gameDataArrary:ArrayList<String> = ArrayList<String>()
    private var gameAnswerArrary:ArrayList<Int> = ArrayList<Int>()
    private var indexNumberArrary:ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9)
    private var answerResult:Int = 0
    private var base:Int = 0
    private var count:Int = 0
    private var baseNumber:Int = 0
    private var subNumber:Int = 0
    private var answerNumber:Int = 3
    private var modeType:Int = 2
    private var gameType:String =  CommonValue().GAME_TYPE_NORMAL
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameDataArrary = SharedPreferencesUtil().getStringArrayPref(this,"GAMES")!!
        gameType = SharedPreferencesUtil().getSingleStringValue(this,CommonValue().SHARED_GAME_TYPE)

        Log.d("BRANDI gameType",gameType)

        base = gameDataArrary[baseNumber].toInt()
        mBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.result.isClickable = true
        binding.result.visibility = View.GONE
        count = 0
        sortCount()
        answerMaker()
        checkAnswer()
    }

    private fun setGame() {
        answerResult =  base * indexNumberArrary[count]
        binding.problemText.text = base.toString()+"X"+ indexNumberArrary[count].toString()
        binding.answerGroup.answer1.text = gameAnswerArrary[0].toString()
        binding.answerGroup.answer2.text = gameAnswerArrary[1].toString()
        binding.answerGroup.answer3.text = gameAnswerArrary[2].toString()

        // 3개 짜리로 변경
//        binding.answer1.text = gameAnswerArrary[0].toString()
//        binding.answer2.text = gameAnswerArrary[1].toString()
//        binding.answer3.text = gameAnswerArrary[2].toString()
//        binding.answer4.text = gameAnswerArrary[3].toString()
//        binding.answer5.text = gameAnswerArrary[4].toString()
//        binding.answer6.text = gameAnswerArrary[5].toString()
    }

    private fun answerMaker() {
        gameAnswerArrary = ArrayList<Int>()
        var limitNumber =  base * indexNumberArrary[count]
        var min =  limitNumber - 2
        var max =  limitNumber + 4

        gameAnswerArrary.add(limitNumber)

        while (gameAnswerArrary.size < answerNumber){
            val num = RandomUtil().rangeSingle(min,max)
            if(!gameAnswerArrary.contains(num) && num != 0){
                gameAnswerArrary.add(num)
            }
        }

        // 섞는다.
        gameAnswerArrary.shuffle()
//        gameAnswerArrary.reverse()
        Log.d("gameAnswerArrary",gameAnswerArrary.toString())
        setGame()
    }

    private fun checkAnswer() {
        binding.answerGroup.answer1.setOnClickListener(){
            setResultText(binding.answerGroup.answer1.text.toString())
        }
        binding.answerGroup.answer2.setOnClickListener(){
            setResultText(binding.answerGroup.answer2.text.toString())
        }
        binding.answerGroup.answer3.setOnClickListener(){
            setResultText(binding.answerGroup.answer3.text.toString())
        }
//        binding.answerGroup.answer4.setOnClickListener(){
//            setResultText(binding.answerGroup.answer4.text.toString())
//        }
//        binding.answer5.setOnClickListener(){
//            setResultText(binding.answer5.text.toString())
//        }
//        binding.answer6.setOnClickListener(){
//            setResultText(binding.answer6.text.toString())
//        }
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
        if(count < 8){
            count++
            binding.result.visibility = View.GONE
            answerMaker()
        }else{
            if(baseNumber < (gameDataArrary.size - 1)){
                baseNumber++
                base = gameDataArrary[baseNumber].toInt()
                count = 0
                binding.result.visibility = View.GONE
                sortCount()
                answerMaker()
            }else{
                Toast.makeText(this, "FINISH", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sortCount() {
        when(gameType){
            CommonValue().GAME_TYPE_NORMAL->  indexNumberArrary.sort()
            CommonValue().GAME_TYPE_REVERSE-> indexNumberArrary.reverse()
            CommonValue().GAME_TYPE_RANDOM-> indexNumberArrary.shuffle()
            else-> indexNumberArrary.sort()
        }
    }

}