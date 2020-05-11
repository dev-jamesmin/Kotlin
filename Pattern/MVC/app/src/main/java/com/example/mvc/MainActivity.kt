package com.example.mvc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvc.controller.StudentController
import com.example.mvc.model.Student
import com.example.mvc.view.StudentView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
    }

    fun start() {
        //fetch student record based on his roll no from the database
        val model = Companion.reliveStudentFromDatabase()

        //Create a view : to write student details on console
        val view = StudentView()
        val controller = StudentController(model, view)
        controller.updateView()

        //update model data
        controller.studentName = "John"
        controller.updateView()
    }

    companion object {
        private fun reliveStudentFromDatabase(): Student {
            val student = Student()
            student.name = "Robert"
            student.rollNo = "10"
            return student
        }
    }


}


