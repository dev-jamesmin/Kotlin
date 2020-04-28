package com.example.convert.view.viewmodel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.convert.R
import com.example.convert.view.java.JavaActivity
import kotlinx.android.synthetic.main.activity_simple.*
import org.koin.android.viewmodel.ext.android.viewModel

class MyViewModelActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    val myViewModel: MyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        title = "MyViewModelActivity"
        text.text = myViewModel.sayHello()

        background.setOnClickListener { _ ->
            startActivity(Intent(this, JavaActivity::class.java))
        }
    }
}
