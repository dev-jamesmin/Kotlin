package com.example.navi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navi.R
import kotlinx.android.synthetic.main.screen_first_home.view.*

class FirstHomeScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_first_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.btn_first_home.setOnClickListener {
            val direction: NavDirections = FirstHomeScreenDirections.actionFirstHomeScreenToTwoDepthScreen(1)
            findNavController().navigate(direction)
        }
    }
}