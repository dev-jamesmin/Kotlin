package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.databinding.data.User
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.user = User("JAMES", "SEOUL", R.drawable.ic_launcher_background)
//        binding.tvSample.text = "test text."//id: tv_sample
        subscribeUi(binding)
    }


    private fun subscribeUi(binding: ActivityMainBinding) {

        var factory = MainViewModelFactory()
        var viewModel: MainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.clickConverter.observe(this, Observer {
            Toast.makeText(this, "${binding.user?.name}, ${binding.user?.address}", Toast.LENGTH_SHORT).show()
        })

        binding.user = User("이종현", "서울시", R.drawable.profile_sample)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }

}
