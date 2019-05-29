package com.example.android_kotlin_recyclerview

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ListAdapter(val activity: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class BaseItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val diversionNameView: TextView = view.findViewById(R.id.text_recipe_name)
        val diversionPriceView: TextView = view.findViewById(R.id.text_recipe_price)
    }

    val data = mutableListOf<Base>()


    init {
        getItems(15)
    }

    fun getItems(qtyToGet: Int) {
        for (i in 0..qtyToGet) {
            DataDao.getBases(object : DataDao.DataCallback {
                override fun callback(diversion: Base) {
                    data.add(diversion)
                    activity.runOnUiThread { notifyDataSetChanged() }
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BaseItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.diversion_item_layout, parent, false))
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, index: Int) {
        if (index == data.size - 5) {
            getItems(5)
        }

        val element = data[index]
        val diversionHolder = viewHolder as BaseItemViewHolder

        diversionHolder.diversionNameView.text = element.name

        diversionHolder.diversionPriceView.text = element.mission
    }
    override fun getItemCount(): Int = data.size

}
