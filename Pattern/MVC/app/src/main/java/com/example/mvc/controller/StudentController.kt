package com.example.mvc.controller

import com.example.mvc.model.Student
import com.example.mvc.view.StudentView


class StudentController(private val model: Student, view: StudentView) {
    private val view: StudentView = view

    var studentName: String?
        get() = model.name
        set(name) {
            model.name = name
        }

    var studentRollNo: String?
        get() = model.rollNo
        set(rollNo) {
            model.rollNo = rollNo
        }

    fun updateView() {
        view.printStudentDetails(model.name, model.rollNo)
    }

}