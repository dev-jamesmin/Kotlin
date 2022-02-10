package com.study.todoapp

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}