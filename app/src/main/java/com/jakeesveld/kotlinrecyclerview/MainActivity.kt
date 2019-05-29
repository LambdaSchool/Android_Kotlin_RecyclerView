package com.jakeesveld.kotlinrecyclerview

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.json.Json


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiURL = "https://rickandmortyapi.com/api/character"
        val characterList = mutableListOf<com.jakeesveld.kotlinrecyclerview.Character>()

        val recyclerView = recycler_view
        val listAdapter = MainListAdapter(characterList)
        recyclerView.adapter = listAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        Thread(Runnable { NetworkAdapter.httpGetRequest(apiURL, object: NetworkAdapter.NetworkCallback{
            override fun returnResult(success: Boolean?, result: String) {
                val charactersList = Json.parse(Base.serializer(), result)
                runOnUiThread(Runnable {
                    charactersList.results?.forEach { characterList.add(it) }
                    listAdapter.notifyDataSetChanged()
                })
            }

            override fun returnImageResult(success: Boolean?, result: Bitmap?, requestUrl: String) {
            }

        } ) }).start()

    }
}
