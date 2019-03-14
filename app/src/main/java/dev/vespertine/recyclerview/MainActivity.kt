package dev.vespertine.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dev.vespertine.recyclerview.RecyclerViewAdapter.DragQueenListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vAdapter = DragQueenListAdapter(this)
        val vManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recyclerView_search).apply {
            setHasFixedSize(false)
            layoutManager = vManager
            adapter = vAdapter
        }
    }
}
