package com.min.timestablegame.option

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.min.timestablegame.common.CommonValue
import com.min.timestablegame.databinding.ActivityOptionBinding
import com.min.timestablegame.util.SharedPreferencesUtil

class OptionActivity : AppCompatActivity() {

    //    전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityOptionBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!
    private val gameArrary:ArrayList<Int> = ArrayList<Int>()
    private var gameDataArrary:ArrayList<String> = ArrayList<String>()
    private var gameOptionDataArrary:ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_option)
        mBinding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPreferencesUtil().getStringArrayPref(this,"GAMES").also {
            if (it != null) {
                gameDataArrary = it
                setCheckBox()
            }
        }

        setRadioData(SharedPreferencesUtil().getSingleStringValue(this,CommonValue().SHARED_GAME_TYPE))
        Log.d("[BRANDI]", "[gameData-Arrary]$gameDataArrary")

        setOptionButtons()
        setDirectionsOption()
        setComplete()
    }

    private fun setDirectionsOption() {
        binding.radioGroup2.radioTypeNormal.setOnClickListener{
            SharedPreferencesUtil().setSingleStringValue(this, CommonValue().SHARED_GAME_TYPE,CommonValue().GAME_TYPE_NORMAL)
        }

        binding.radioGroup2.radioTypeRandom.setOnClickListener{
            SharedPreferencesUtil().setSingleStringValue(this,CommonValue().SHARED_GAME_TYPE,CommonValue().GAME_TYPE_RANDOM)
        }

        binding.radioGroup2.radioTypeReverse.setOnClickListener{
            SharedPreferencesUtil().setSingleStringValue(this,CommonValue().SHARED_GAME_TYPE,CommonValue().GAME_TYPE_REVERSE)
        }
    }

     private fun setOptionButtons() {
         Log.d("[BRANDI]", "[setOptionButtons]")
         binding.checkbox2.setOnClickListener(){
             if(binding.checkbox2.isChecked){
                 gameArrary.add(2)
             }else{
                 gameArrary.remove(2)
             }
         }
         binding.checkbox3.setOnClickListener(){
             if(binding.checkbox3.isChecked){
                 gameArrary.add(3)
             }else{
                 gameArrary.remove(3)
             }
         }

         binding.checkbox4.setOnClickListener(){
             if(binding.checkbox4.isChecked){
                 gameArrary.add(4)
             }else{
                 gameArrary.remove(4)
             }
         }

         binding.checkbox5.setOnClickListener(){
             if(binding.checkbox5.isChecked){
                 gameArrary.add(5)
             }else{
                 gameArrary.remove(5)
             }
         }

         binding.checkbox6.setOnClickListener(){
             if(binding.checkbox6.isChecked){
                 gameArrary.add(6)
             }else{
                 gameArrary.remove(6)
             }
         }

         binding.checkbox7.setOnClickListener(){
             if(binding.checkbox7.isChecked){
                 gameArrary.add(7)
             }else{
                 gameArrary.remove(7)
             }
         }

         binding.checkbox8.setOnClickListener(){
             if(binding.checkbox8.isChecked){
                 gameArrary.add(8)
             }else{
                 gameArrary.remove(8)
             }
         }

         binding.checkbox9.setOnClickListener(){
             if(binding.checkbox9.isChecked){
                 gameArrary.add(9)
             }else{
                 gameArrary.remove(9)
             }
         }
    }

    private fun setCheckBox() {

        gameDataArrary
        var number = 0
        while (number < (gameDataArrary.size)){
            setCheckBoxData(gameDataArrary[number].toInt())
            number += 1
        }


        binding.completeButton.setOnClickListener(){
            Log.d("[BRANDI]", "[RESULT]$gameArrary")
            finishOption()
        }
    }

    private fun setCheckBoxData(num:Int) {
        Log.d("[BRANDI]", "[num]$num")
        gameArrary.add(num)
        when(num){
            2->  binding.checkbox2.isChecked = true
            3-> binding.checkbox3.isChecked = true
            4-> binding.checkbox4.isChecked = true
            5-> binding.checkbox5.isChecked = true
            6-> binding.checkbox6.isChecked = true
            7-> binding.checkbox7.isChecked = true
            8-> binding.checkbox8.isChecked = true
            9-> binding.checkbox9.isChecked = true
            else-> "3"
        }
    }

    private fun setRadioData(gameType:String) {
        Log.d("[BRANDI]", "[num]$gameType")
        when(gameType){
            CommonValue().GAME_TYPE_NORMAL->  binding.radioGroup2.radioTypeNormal.isChecked = true
            CommonValue().GAME_TYPE_RANDOM-> binding.radioGroup2.radioTypeRandom.isChecked = true
            CommonValue().GAME_TYPE_REVERSE->  binding.radioGroup2.radioTypeReverse.isChecked = true
            else-> binding.radioGroup2.radioTypeNormal.isChecked = true
        }
    }



    private fun setComplete() {
        binding.completeButton.setOnClickListener(){
            Log.d("[BRANDI]", "[RESULT]$gameArrary")
            finishOption()
        }
    }

    private fun finishOption() {
        if(0 < gameArrary.size){
            SharedPreferencesUtil().setIntArrayPref(this,"GAMES",gameArrary)
            finish()
        }else{
            Toast.makeText(this, "1개이상 선택해주세요", Toast.LENGTH_SHORT).show()
        }
    }

}