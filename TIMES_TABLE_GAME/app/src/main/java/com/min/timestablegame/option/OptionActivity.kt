package com.min.timestablegame.option

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.min.timestablegame.databinding.ActivityOptionBinding

class OptionActivity : AppCompatActivity() {

    //    전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityOptionBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    private val gameArrary:ArrayList<Int> = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_option)
        mBinding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOptionButtons()
        setComplete()
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

    private fun setComplete() {
        binding.completeButton.setOnClickListener(){
            Log.d("[BRANDI]", "[RESULT]$gameArrary")
            finishOption()
        }
    }

    private fun finishOption() {

    }

}