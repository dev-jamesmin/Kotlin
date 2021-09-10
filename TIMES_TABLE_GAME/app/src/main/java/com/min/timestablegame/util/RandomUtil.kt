package com.min.timestablegame.util
import java.util.*

class RandomUtil {
    fun singleNumber(limit:Int):Int {
        return  Random().nextInt(limit)
    }

    fun rangeSingle(min:Int,max:Int):Int {
        return Random().nextInt(max - min + 1) + min
    }
}