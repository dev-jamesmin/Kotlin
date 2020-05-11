package com.example.mvvm.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import com.example.mvvm.model.Board

class TicTacToeViewModel : ViewModel {
    private val model: Board = Board()
    val cells = ObservableArrayMap<String, String?>()
    val winner = ObservableField<String?>()
    override fun onCreate() {}
    override fun onPause() {}
    override fun onResume() {}
    override fun onDestroy() {}
    fun onResetSelected() {
        model.restart()
        winner.set(null)
        cells.clear()
    }

    fun onClickedCellAt(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)
        cells["" + row + col] = playerThatMoved?.toString()
        winner.set(if (model.winner == null) null else model.winner.toString())
    }

}