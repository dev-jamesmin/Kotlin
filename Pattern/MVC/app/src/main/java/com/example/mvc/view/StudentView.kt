package com.example.mvc.view

import android.util.Log

class StudentView {
    fun printStudentDetails(studentName: String?, studentRollNo: String?) {
        println("Student: ")
        println("Name: $studentName")
        println("Roll No: $studentRollNo")
        Log.d("[DEBUG]","Student: ")
        Log.d("[DEBUG]", "Name: $studentName")
        Log.d("[DEBUG]", "Roll No: $studentRollNo")
    }
}