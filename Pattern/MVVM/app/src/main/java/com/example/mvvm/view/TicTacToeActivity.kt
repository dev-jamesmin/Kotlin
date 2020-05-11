package com.example.mvvm.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvm.R
import com.example.mvvm.databinding.TictactoeBinding
import com.example.mvvm.viewmodel.TicTacToeViewModel

open class TicTacToeActivity : AppCompatActivity() {
    private var viewModel: TicTacToeViewModel = TicTacToeViewModel()
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: TictactoeBinding = DataBindingUtil.setContentView(this, R.layout.tictactoe)
        binding.viewModel = viewModel
        viewModel.onCreate()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reset -> {
                viewModel.onResetSelected()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}