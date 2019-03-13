package com.jbseppanen.android_kotlin_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        DataDao.getDiversions(object : DataDao.DataCallback {
            override fun callback(diversion: Diversion) {
                runOnUiThread { findViewById<TextView>(R.id.test).text = diversion.activity }
            }
        })


    }
}
