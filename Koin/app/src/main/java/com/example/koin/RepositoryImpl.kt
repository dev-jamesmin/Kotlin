package com.example.koin


class RepositoryImpl : Repository {

    override fun getMyData(): String {
        return "Hello Koin"
    }

}