package com.example.convert.view.scope

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.convert.R
import kotlinx.android.synthetic.main.activity_simple.*
import org.koin.android.scope.lifecycleScope
import com.example.convert.view.viewmodel.MyViewModelActivity

class MyScopeActivity : AppCompatActivity() {

    // lazy injected MyScopePresenter
    private val presenter: MyScopePresenter by lifecycleScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        println("presenter -> $presenter")

        title = "MyScopeActivity"
        text.text = presenter.sayHello()

        background.setOnClickListener { _ ->
            startActivity(Intent(this, MyViewModelActivity::class.java))
        }
    }
}
