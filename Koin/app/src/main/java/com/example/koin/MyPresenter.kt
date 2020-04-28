package com.example.koin

class MyPresenter(private val repository: Repository) {

    fun sayHello() = "${repository.getMyData()} from $this"

}