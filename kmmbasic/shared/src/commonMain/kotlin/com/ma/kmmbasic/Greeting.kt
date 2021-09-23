package com.ma.kmmbasic

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}