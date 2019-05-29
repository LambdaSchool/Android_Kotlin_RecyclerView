package com.jakeesveld.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characterList = mutableListOf<Character>()

        val recyclerView = recycler_view
        val listAdapter = MainListAdapter(characterList)
        recyclerView.adapter = listAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}
