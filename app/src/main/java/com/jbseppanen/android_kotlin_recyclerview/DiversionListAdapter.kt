package com.jbseppanen.android_kotlin_recyclerview

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DiversionListAdapter(val activity: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class DiversionItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val diversionNameView: TextView = view.findViewById(R.id.text_diversion_name)
        val diversionPriceView: TextView = view.findViewById(R.id.text_diversion_price)
    }

    val data = mutableListOf<Diversion>()


    init {
        getItems(15)
    }

    fun getItems(qtyToGet: Int) {
        for (i in 0..qtyToGet) {
            DataDao.getDiversions(object : DataDao.DataCallback {
                override fun callback(diversion: Diversion) {
                    data.add(diversion)
                    activity.runOnUiThread { notifyDataSetChanged() }
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DiversionItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.diversion_item_layout, parent, false))
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, index: Int) {
        if (index == data.size - 5) {
            getItems(5)
        }

        val element = data[index]
        val diversionHolder = viewHolder as DiversionItemViewHolder

        diversionHolder.diversionNameView.text = element.activity
        val cost: String = when {
            element.price!! < .333 -> "$"
            element.price < .666 -> "$$"
            else -> "$$$"
        }
        diversionHolder.diversionPriceView.text = cost
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
