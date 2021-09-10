package com.min.timestablegame.util

import android.content.Context
import androidx.preference.PreferenceManager
import org.json.JSONException
import org.json.JSONArray

class SharedPreferencesUtil {
     fun setIntArrayPref(context: Context, key: String, values: ArrayList<Int>) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        val a = JSONArray()
        for (i in 0 until values.size) {
            a.put(values[i])
        }
        if (values.isNotEmpty()) {
            editor.putString(key, a.toString())
        } else {
            editor.putString(key, null)
        }
        editor.apply()
    }

     fun getStringArrayPref(context: Context, key: String): ArrayList<String>? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val json = prefs.getString(key, null)
        val urls = ArrayList<String>()
        if (json != null) {
            try {
                val a = JSONArray(json)
                for (i in 0 until a.length()) {
                    // 강제 타입 변경이라 위험.
                    val url = a.optString(i)
                    urls.add(url)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return urls
    }

    fun setSingleStringValue(context: Context,
                             stringKey: String? = null,
                             value:String? = null) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        if(value != null){ editor.putString(stringKey, value) }
        editor.commit()
    }

    fun getSingleStringValue(context: Context, key: String):String {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getString(key, "").toString()
    }

    fun setSingleIntValue(context: Context,
                          intKey: String? = null,
                          intValue:Int? = null ) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        if(intValue != null){ editor.putInt(intKey, intValue) }
        editor.commit()
    }


    fun getSingleIntValue(context: Context, key: String): Int {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences.getInt(key, -1)
    }

    fun getStringValue(context: Context, key: String, values: ArrayList<Int>) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        val a = JSONArray()
        for (i in 0 until values.size) {
            a.put(values[i])
        }
        if (values.isNotEmpty()) {
            editor.putString(key, a.toString())
        } else {
            editor.putString(key, null)
        }
        editor.apply()
    }
}
