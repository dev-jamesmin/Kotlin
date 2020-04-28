package com.example.coresample

import android.app.Application
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin
import org.koin.core.inject
import org.koin.sample.HelloService
import org.koin.sample.helloModule

/**
 * HelloApplication - Application Class
 * use HelloService
 */
//class HelloApplication : KoinComponent {
//
//    // Inject HelloService
//    val helloService: HelloService by inject()
//
//    // display our data
//    fun sayHello() = println(helloService.hello())
//}
//
///**
// * run app from here
// */
//fun main() {
//
//    startKoin {
//        printLogger()
//        modules(helloModule)
//    }
//    HelloApplication().sayHello()
//}


class HelloApplication : Application() {

    // Inject HelloService
    val helloService: HelloService by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
//            androidContext(this@MyApplication)
//            modules(appModule)
            printLogger()
            modules(helloModule)
        }
//        sayHello()
    }



    // display our data
    fun sayHello() = println(helloService.hello())
}