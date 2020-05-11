package com.example.mvp.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.R
import com.example.mvp.data.source.image.SampleImageRepository
import com.example.mvp.view.main.presenter.MainContract
import com.example.mvp.view.main.presenter.MainPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.example.mvp.adapter.ImageAdapter

class MainActivity : AppCompatActivity(), MainContract.View {

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    private lateinit var imageAdapter: ImageAdapter

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)

        imageAdapter = ImageAdapter(this)
        recyclerView.adapter = imageAdapter

        presenter = MainPresenter().apply {
            view = this@MainActivity
            imageData = SampleImageRepository
            adapterModel = imageAdapter
            adapterView = imageAdapter
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }

        presenter.loadItems(this, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reload) {
            presenter.loadItems(this, true)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showToast(title: String) {
        Toast.makeText(this, "OnClick Item $title", Toast.LENGTH_SHORT).show()
    }
}
