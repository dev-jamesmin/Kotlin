package com.example.convert.view.simple

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.convert.R
import kotlinx.android.synthetic.main.activity_simple.*
import org.koin.android.ext.android.inject
import com.example.convert.view.scope.MyScopeActivity

class MySimpleActivity : AppCompatActivity() {

    // Lazy injected MySimplePresenter
    private val firstPresenter: MySimplePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        title = "MySimpleActivity"
        text.text = firstPresenter.sayHello()

        background.setOnClickListener { _ ->
            startActivity(Intent(this, MyScopeActivity::class.java))
        }
    }
}
